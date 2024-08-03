package com.wcg.wcg.api.dto.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class RaceModifyRequestDto {
    private String name;
    private List<UUID> defaultSkills;
    private List<UUID> defaultTalents;
}
