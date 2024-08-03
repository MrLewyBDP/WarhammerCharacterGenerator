package com.wcg.wcg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wcg.wcg.api.dto.request.RaceCreateRequestDto;
import com.wcg.wcg.api.dto.request.RaceModifyRequestDto;
import com.wcg.wcg.api.dto.response.RaceResponseDto;
import com.wcg.wcg.api.dto.search.RaceSearchDto;
import com.wcg.wcg.api.exceptions.NotFoundException;
import com.wcg.wcg.entity.RaceEntity;
import com.wcg.wcg.entity.SkillEntity;
import com.wcg.wcg.entity.TalentEntity;
import com.wcg.wcg.mapper.RaceMapper;
import com.wcg.wcg.repository.RaceRepository;
import com.wcg.wcg.repository.SkillRepository;
import com.wcg.wcg.repository.TalentRepository;
import com.wcg.wcg.specification.RaceSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceMapper raceMapper;
    private final RaceRepository raceRepository;
    private final SkillRepository skillRepository;
    private final TalentRepository talentRepository;
    
    public RaceResponseDto createRace(RaceCreateRequestDto request) {

        List<SkillEntity> skillsList = new ArrayList<SkillEntity>();
        if(request.getDefaultSkills()!=null)
        {
            Iterable<SkillEntity> skillsIterable = skillRepository.findAllById(request.getDefaultSkills());
            skillsIterable.forEach(skillsList::add);
        }

        List<TalentEntity> talentsList = new ArrayList<TalentEntity>();
        if(request.getDefaultTalents()!=null)
        {
            Iterable<TalentEntity> talentsIterable = talentRepository.findAllById(request.getDefaultTalents());
            talentsIterable.forEach(talentsList::add);
        }
        
        return raceMapper.toResponse(raceRepository.save(raceMapper.toEntity(request, skillsList, talentsList)));
    }

    public RaceResponseDto findRaceById(UUID id) {

        return raceMapper.toResponse(raceRepository.findById(id).orElseThrow(() -> new NotFoundException(id)));
    }

    public List<RaceResponseDto> searchRaces(RaceSearchDto request, int page, int pageSize) {

        Page<RaceEntity> pages = raceRepository.findAll(new RaceSpecification(request), PageRequest.of(page, pageSize));
        Page<RaceResponseDto> responsePages = pages.map(raceMapper::toResponse);
        return responsePages.getContent();
    }

    public RaceResponseDto modifyRace(UUID id, RaceModifyRequestDto request) {

        RaceEntity entity = raceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        Iterable<SkillEntity> skillsIterable = skillRepository.findAllById(request.getDefaultSkills());
        List<SkillEntity> skillsList = new ArrayList<SkillEntity>();
        skillsIterable.forEach(skillsList::add);

        Iterable<TalentEntity> talentsIterable = talentRepository.findAllById(request.getDefaultTalents());
        List<TalentEntity> talentsList = new ArrayList<TalentEntity>();
        talentsIterable.forEach(talentsList::add);

        raceMapper.modifyEntity(entity, request, skillsList, talentsList);
        return raceMapper.toResponse(raceRepository.save(entity));
    }

    public void deleteRace(UUID id) {

        raceRepository.deleteById(id);
    }
}
