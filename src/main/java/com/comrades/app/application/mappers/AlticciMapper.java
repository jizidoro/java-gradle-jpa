package com.comrades.app.application.mappers;

import com.comrades.app.application.services.alticci.dtos.AlticciDto;
import com.comrades.app.domain.models.Alticci;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlticciMapper {

    AlticciMapper INSTANCE = Mappers.getMapper(AlticciMapper.class);

    AlticciDto toAlticciDto(Alticci alticci);

    Alticci toAlticci(AlticciDto alticciDto);
}
