package com.wcg.wcg.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.wcg.wcg.api.dto.request.SkillCreateRequestDto;
import com.wcg.wcg.api.dto.request.SkillModifyRequestDto;
import com.wcg.wcg.api.dto.response.SkillResponseDto;
import com.wcg.wcg.entity.SkillEntity;

@Mapper(config = MapperConfiguration.class)
public interface SkillMapper {
    @Mapping(target = "id", ignore = true)
    SkillEntity toEntity(SkillCreateRequestDto request);

    SkillResponseDto toResponse(SkillEntity entity);

    @Mapping(target = "id", ignore = true)
    void modifyEntity(@MappingTarget SkillEntity entity, SkillModifyRequestDto request);

    List<SkillResponseDto> ToSkillsList(List<SkillEntity> list);
}
