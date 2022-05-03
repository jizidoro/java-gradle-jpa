package com.comrades.app.application.services.airplane;

import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.domain.models.Airplane;

public interface IAirplaneCommand {
    Airplane save(AirplaneDto airplane);

    Boolean update(AirplaneDto airplane);

    Boolean delete(Long id);
}
