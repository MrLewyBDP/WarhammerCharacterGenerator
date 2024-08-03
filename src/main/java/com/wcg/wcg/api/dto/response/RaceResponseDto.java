package com.wcg.wcg.api.dto.response;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class RaceResponseDto {
    private UUID id;
    private String name;
    private List<SkillResponseDto> defaultSkills;
    private List<TalentResponseDto> defaultTalents;
}
