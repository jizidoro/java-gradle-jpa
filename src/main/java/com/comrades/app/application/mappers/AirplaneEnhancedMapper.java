package com.comrades.app.application.mappers;


import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.application.services.airplane.dtos.FuelTypeEnum;
import com.comrades.app.domain.models.Airplane;
import com.comrades.app.domain.models.BioDieselAirplane;
import com.comrades.app.domain.models.ElectricAirplane;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class AirplaneEnhancedMapper {

    @BeforeMapping
    protected void enrichDtoWithFuelType(Airplane airplane, @MappingTarget AirplaneDto airplaneDto) {
        if (airplane instanceof ElectricAirplane)
            airplaneDto.setFuelType(FuelTypeEnum.ELECTRIC);
        if (airplane instanceof BioDieselAirplane)
            airplaneDto.setFuelType(FuelTypeEnum.BIO_DIESEL);
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget AirplaneDto airplaneDto) {
        airplaneDto.setCodigo(airplaneDto.getCodigo().toUpperCase());
    }

    public abstract AirplaneDto toAirplaneDto(Airplane airplane);

}
