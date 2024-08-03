package com.wcg.wcg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wcg.wcg.api.dto.request.SkillCreateRequestDto;
import com.wcg.wcg.api.dto.request.SkillModifyRequestDto;
import com.wcg.wcg.api.dto.response.SkillResponseDto;
import com.wcg.wcg.api.dto.search.SkillSearchDto;
import com.wcg.wcg.api.exceptions.NotFoundException;
import com.wcg.wcg.entity.SkillEntity;
import com.wcg.wcg.mapper.SkillMapper;
import com.wcg.wcg.repository.SkillRepository;
import com.wcg.wcg.specification.SkillSpecification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SkillService {
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;
    public SkillResponseDto createSkill(SkillCreateRequestDto request) {
        return skillMapper.toResponse(skillRepository.save(skillMapper.toEntity(request)));
    }

    public SkillResponseDto findSkillById(UUID id) {
        return skillMapper.toResponse(skillRepository.findById(id).orElseThrow(() -> new NotFoundException(id)));
    }

    public SkillResponseDto modifySkill(UUID id, SkillModifyRequestDto request) {
        SkillEntity entity = skillRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        skillMapper.modifyEntity(entity, request);
        return skillMapper.toResponse(skillRepository.save(entity));
    }

    public void deleteSkill(UUID id) {
        skillRepository.deleteById(id);
    }

    public List<SkillResponseDto> searchSkills(SkillSearchDto request, int page, int pageSize) {
        Page<SkillEntity> pages = skillRepository.findAll(new SkillSpecification(request), PageRequest.of(page, pageSize));
        Page<SkillResponseDto> responsePages = pages.map(skillMapper::toResponse);
        return responsePages.getContent();
    }
}
