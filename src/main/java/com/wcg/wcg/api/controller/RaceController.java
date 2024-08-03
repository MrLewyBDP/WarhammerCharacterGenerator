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

import com.wcg.wcg.api.dto.request.RaceCreateRequestDto;
import com.wcg.wcg.api.dto.request.RaceModifyRequestDto;
import com.wcg.wcg.api.dto.response.RaceResponseDto;
import com.wcg.wcg.api.dto.search.RaceSearchDto;

public interface RaceController {
    
    @PostMapping("/races")
    RaceResponseDto createRace(@RequestBody RaceCreateRequestDto request);

    @GetMapping("/races/{id}")
    RaceResponseDto findRaceById(@PathVariable("id") UUID id);

    @GetMapping("/races")
    List<RaceResponseDto> searchRaces(RaceSearchDto request, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @PutMapping("/races/{id}")
    RaceResponseDto modifyRace(@PathVariable("id") UUID id, @RequestBody RaceModifyRequestDto request);

    @DeleteMapping("/races/{id}")
    void deleteRace(@PathVariable("id") UUID id);

}
