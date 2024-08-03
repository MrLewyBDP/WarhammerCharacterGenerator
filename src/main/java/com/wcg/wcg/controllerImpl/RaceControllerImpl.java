package com.wcg.wcg.controllerImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.wcg.wcg.api.controller.RaceController;
import com.wcg.wcg.api.dto.request.RaceCreateRequestDto;
import com.wcg.wcg.api.dto.request.RaceModifyRequestDto;
import com.wcg.wcg.api.dto.response.RaceResponseDto;
import com.wcg.wcg.api.dto.search.RaceSearchDto;
import com.wcg.wcg.service.RaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RaceControllerImpl implements RaceController {

    private final RaceService raceService;

    @Override
    public RaceResponseDto createRace(RaceCreateRequestDto request) {

        return raceService.createRace(request);
    }

    @Override
    public RaceResponseDto findRaceById(UUID id) {

        return raceService.findRaceById(id);
    }

    @Override
    public List<RaceResponseDto> searchRaces(RaceSearchDto request, int page, int pageSize) {

        return raceService.searchRaces(request, page, pageSize);
    }

    @Override
    public RaceResponseDto modifyRace(UUID id, RaceModifyRequestDto request) {

        return raceService.modifyRace(id, request);
    }

    @Override
    public void deleteRace(UUID id) {

        raceService.deleteRace(id);
    }

}
