package com.comrades.app.application.mappers;


import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.domain.models.Airplane;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class AirplaneEnhancedMapper {

    @BeforeMapping
    protected void enrichDtoWithFuelType(Airplane airplane, @MappingTarget AirplaneDto airplaneDto) {

    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget AirplaneDto airplaneDto) {
        airplaneDto.setCode(airplaneDto.getCode().toUpperCase());
    }

    public abstract AirplaneDto toAirplaneDto(Airplane airplane);

}
