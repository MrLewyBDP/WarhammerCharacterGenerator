package com.wcg.wcg.controllerImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.wcg.wcg.api.controller.SkillController;
import com.wcg.wcg.api.dto.request.SkillCreateRequestDto;
import com.wcg.wcg.api.dto.request.SkillModifyRequestDto;
import com.wcg.wcg.api.dto.response.SkillResponseDto;
import com.wcg.wcg.api.dto.search.SkillSearchDto;
import com.wcg.wcg.service.SkillService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SkillControllerImpl implements SkillController {
    private final SkillService skillService;

    @Override
    public SkillResponseDto createSkill(SkillCreateRequestDto request) {
        return skillService.createSkill(request);
    }

    @Override
    public SkillResponseDto findSkillById(UUID id) {
        return skillService.findSkillById(id);
    }

    @Override
    public SkillResponseDto modifySkill(UUID id, SkillModifyRequestDto request) {
        return skillService.modifySkill(id, request);
    }

    @Override
    public void deleteSkill(UUID id) {
        skillService.deleteSkill(id);
    }

    @Override
    public List<SkillResponseDto> searchSkills(SkillSearchDto request, int page, int pageSize) {
        return skillService.searchSkills(request, page, pageSize);
    }

}
