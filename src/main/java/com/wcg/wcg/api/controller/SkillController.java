package com.wcg.wcg.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcg.wcg.api.dto.request.SkillCreateRequestDto;
import com.wcg.wcg.api.dto.request.SkillModifyRequestDto;
import com.wcg.wcg.api.dto.response.SkillResponseDto;
import com.wcg.wcg.api.dto.search.SkillSearchDto;

public interface SkillController {
    
    @PostMapping("/skills")
    SkillResponseDto createSkill(@RequestBody SkillCreateRequestDto request);

    @GetMapping("/skills/{id}")
    SkillResponseDto findSkillById(@PathVariable("id") UUID id);

    @GetMapping("/skills")
    List<SkillResponseDto> searchSkills(SkillSearchDto request, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @PutMapping("/skills/{id}")
    SkillResponseDto modifySkill(@PathVariable("id") UUID id, @RequestBody SkillModifyRequestDto request);

    @DeleteMapping("/skills/{id}")
    void deleteSkill(@PathVariable("id") UUID id);

}
