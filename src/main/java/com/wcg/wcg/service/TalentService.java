package com.wcg.wcg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wcg.wcg.api.dto.request.TalentCreateRequestDto;
import com.wcg.wcg.api.dto.request.TalentModifyRequestDto;
import com.wcg.wcg.api.dto.response.TalentResponseDto;
import com.wcg.wcg.api.dto.search.TalentSearchDto;
import com.wcg.wcg.api.exceptions.NotFoundException;
import com.wcg.wcg.entity.TalentEntity;
import com.wcg.wcg.mapper.TalentMapper;
import com.wcg.wcg.repository.TalentRepository;
import com.wcg.wcg.specification.TalentSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TalentService {

    private final TalentMapper talentMapper;
    private final TalentRepository talentRepository;

    public TalentResponseDto createTalent(TalentCreateRequestDto request) {
        return talentMapper.toResponse(talentRepository.save(talentMapper.toEntity(request)));
    }

    public TalentResponseDto findTalentById(UUID id) {
        return talentMapper.toResponse(talentRepository.findById(id).orElseThrow(() -> new NotFoundException(id)));
    }

    public List<TalentResponseDto> searchTalents(TalentSearchDto request, int page, int pageSize) {
        Page<TalentEntity> pages = talentRepository.findAll(new TalentSpecification(request), PageRequest.of(page, pageSize));
        Page<TalentResponseDto> responsePages = pages.map(talentMapper::toResponse);
        return responsePages.getContent();
    }

    public TalentResponseDto modifyTalent(UUID id, TalentModifyRequestDto request) {
        TalentEntity entity = talentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        talentMapper.modifyEntity(entity, request);
        return talentMapper.toResponse(talentRepository.save(entity));
    }
    public void deleteTalent(UUID id) {
        talentRepository.deleteById(id);
    }
}
