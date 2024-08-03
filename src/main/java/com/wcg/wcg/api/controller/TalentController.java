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

import com.wcg.wcg.api.dto.request.TalentCreateRequestDto;
import com.wcg.wcg.api.dto.request.TalentModifyRequestDto;
import com.wcg.wcg.api.dto.response.TalentResponseDto;
import com.wcg.wcg.api.dto.search.TalentSearchDto;

public interface TalentController {
    
    @PostMapping("/talents")
    TalentResponseDto createTalent(@RequestBody TalentCreateRequestDto request);

    @GetMapping("/talents/{id}")
    TalentResponseDto findTalentById(@PathVariable("id") UUID id);

    @GetMapping("/talents")
    List<TalentResponseDto> searchTalents(TalentSearchDto searchText, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @PutMapping("/talents/{id}")
    TalentResponseDto modifyTalent(@PathVariable("id") UUID id, @RequestBody TalentModifyRequestDto request);

    @DeleteMapping("talents/{id}")
    void deleteTalent(@PathVariable("id") UUID id);
}
