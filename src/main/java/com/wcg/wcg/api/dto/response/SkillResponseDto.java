package com.wcg.wcg.api.dto.response;

import java.util.UUID;

import lombok.Data;

@Data
public class SkillResponseDto {
    private UUID id;
    private String name;
    private String description;
}
