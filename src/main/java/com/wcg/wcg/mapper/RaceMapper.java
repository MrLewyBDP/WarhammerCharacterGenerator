package com.wcg.wcg.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.wcg.wcg.api.dto.request.RaceCreateRequestDto;
import com.wcg.wcg.api.dto.request.RaceModifyRequestDto;
import com.wcg.wcg.api.dto.response.RaceResponseDto;
import com.wcg.wcg.entity.RaceEntity;
import com.wcg.wcg.entity.SkillEntity;
import com.wcg.wcg.entity.TalentEntity;

@Mapper(config = MapperConfiguration.class)
public interface RaceMapper {

    RaceResponseDto toResponse(RaceEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "defaultSkills", source = "defaultSkills")
    @Mapping(target = "defaultTalents", source = "defaultTalents")
    RaceEntity toEntity(RaceCreateRequestDto request, List<SkillEntity> defaultSkills, List<TalentEntity> defaultTalents);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "defaultSkills", source = "defaultSkills")
    @Mapping(target = "defaultTalents", source = "defaultTalents")
    void modifyEntity(@MappingTarget RaceEntity entity, RaceModifyRequestDto request, List<SkillEntity> defaultSkills, List<TalentEntity> defaultTalents);
}
