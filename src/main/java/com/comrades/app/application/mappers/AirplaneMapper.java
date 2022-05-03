package com.comrades.app.application.mappers;

import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.domain.models.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {

    AirplaneMapper INSTANCE = Mappers.getMapper(AirplaneMapper.class);

    AirplaneDto toAirplaneDto(Airplane airplane);

    Airplane toAirplane(AirplaneDto airplaneDto);
}
