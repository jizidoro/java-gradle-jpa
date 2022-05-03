package com.comrades.app.application.services.airplane.commands;

import com.comrades.app.application.mappers.AirplaneMapper;
import com.comrades.app.application.services.airplane.IAirplaneCommand;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.core.airplane.usecases.UcAirplaneCreate;
import com.comrades.app.core.airplane.usecases.UcAirplaneDelete;
import com.comrades.app.core.airplane.usecases.UcAirplaneEdit;
import com.comrades.app.core.bases.UseCaseFacade;
import com.comrades.app.domain.models.Airplane;
import com.comrades.app.persistence.repositories.IAirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AirplaneCommand implements IAirplaneCommand {

    private final IAirplaneRepository _airplaneRepository;
    private final UseCaseFacade facade;

    public Airplane save(AirplaneDto airplane) {
        var result = AirplaneMapper.INSTANCE.toAirplane(airplane);
        var uc = new UcAirplaneCreate(result);
        return facade.execute(uc);
    }

    public Boolean update(AirplaneDto airplane) {
        var result = AirplaneMapper.INSTANCE.toAirplane(airplane);
        var uc = new UcAirplaneEdit(result);
        facade.execute(uc);
        return true;
    }

    public Boolean delete(int id) {
        var uc = new UcAirplaneDelete(id);
        facade.execute(uc);
        return true;
    }
}
