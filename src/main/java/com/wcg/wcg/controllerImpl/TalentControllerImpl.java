package com.wcg.wcg.controllerImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.wcg.wcg.api.controller.TalentController;
import com.wcg.wcg.api.dto.request.TalentCreateRequestDto;
import com.wcg.wcg.api.dto.request.TalentModifyRequestDto;
import com.wcg.wcg.api.dto.response.TalentResponseDto;
import com.wcg.wcg.api.dto.search.TalentSearchDto;
import com.wcg.wcg.service.TalentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TalentControllerImpl implements TalentController {

    private final TalentService talentService;

    @Override
    public TalentResponseDto createTalent(TalentCreateRequestDto request) {
        return talentService.createTalent(request);
    }

    @Override
    public TalentResponseDto findTalentById(UUID id) {
        return talentService.findTalentById(id);
    }

    @Override
    public List<TalentResponseDto> searchTalents(TalentSearchDto searchText, int page, int pageSize) {
        return talentService.searchTalents(searchText, page, pageSize);
    }

    @Override
    public TalentResponseDto modifyTalent(UUID id, TalentModifyRequestDto request) {
        return talentService.modifyTalent(id, request);
    }

    @Override
    public void deleteTalent(UUID id) {
        talentService.deleteTalent(id);
    }
    
}
