package com.comrades.app.application.mappers;


import com.comrades.app.application.services.alticci.dtos.AlticciDto;
import com.comrades.app.domain.models.Alticci;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class AlticciEnhancedMapper {

    @BeforeMapping
    protected void enrichDtoWithFuelType(Alticci alticci, @MappingTarget AlticciDto alticciDto) {

    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget AlticciDto alticciDto) {
        alticciDto.setCode(alticciDto.getCode().toUpperCase());
    }

    public abstract AlticciDto toAlticciDto(Alticci alticci);

}
