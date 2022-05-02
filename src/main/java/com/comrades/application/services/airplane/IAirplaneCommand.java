package com.comrades.application.services.airplane;

import com.comrades.application.services.airplane.dtos.AirplaneDto;
import com.comrades.domain.models.Airplane;



import java.util.List;

public interface IAirplaneCommand {
    Airplane save(AirplaneDto airplane);

    Boolean update(AirplaneDto airplane);

    Boolean delete(int id);
}
