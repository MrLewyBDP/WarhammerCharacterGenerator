package com.wcg.wcg.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.wcg.wcg.api.dto.request.TalentCreateRequestDto;
import com.wcg.wcg.api.dto.request.TalentModifyRequestDto;
import com.wcg.wcg.api.dto.response.TalentResponseDto;
import com.wcg.wcg.entity.TalentEntity;

@Mapper(config = MapperConfiguration.class)
public interface TalentMapper {

    TalentResponseDto toResponse(TalentEntity entity);

    @Mapping(target = "id", ignore = true)
    TalentEntity toEntity(TalentCreateRequestDto request);

    @Mapping(target = "id", ignore = true)
    void modifyEntity(@MappingTarget TalentEntity entity, TalentModifyRequestDto request);

    List<TalentResponseDto> toTalentsList(List<TalentEntity> list);
}
