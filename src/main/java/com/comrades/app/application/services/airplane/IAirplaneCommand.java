package com.comrades.app.application.services.airplane;

import com.comrades.app.application.services.airplane.dtos.AirplaneDto;

public interface IAirplaneCommand {
    Integer save(AirplaneDto airplane);

    Integer update(AirplaneDto airplane);

    Integer delete(Long id);
}
