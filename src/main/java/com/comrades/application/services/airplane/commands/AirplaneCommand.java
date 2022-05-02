package com.comrades.application.services.airplane.commands;

import com.comrades.application.mappers.AirplaneMapper;
import com.comrades.application.services.airplane.IAirplaneCommand;
import com.comrades.application.services.airplane.dtos.AirplaneDto;
import com.comrades.core.airplane.usecases.UcAirplaneCreate;
import com.comrades.core.airplane.usecases.UcAirplaneDelete;
import com.comrades.core.airplane.usecases.UcAirplaneEdit;
import com.comrades.core.bases.UseCaseFacade;
import com.comrades.domain.models.Airplane;
import com.comrades.persistence.repositories.IAirplaneRepository;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;



import java.util.List;

@Service
@Slf4j
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
