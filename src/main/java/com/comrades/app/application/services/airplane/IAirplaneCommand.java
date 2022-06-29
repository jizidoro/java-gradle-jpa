package com.comrades.app.application.services.airplane;

import com.comrades.app.application.services.airplane.dtos.AirplaneDto;

import java.util.UUID;

public interface IAirplaneCommand {
    Integer save(AirplaneDto airplane);

    Integer update(AirplaneDto airplane);

    Integer delete(UUID id);
}
