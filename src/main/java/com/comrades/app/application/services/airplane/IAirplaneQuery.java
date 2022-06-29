package com.comrades.app.application.services.airplane;

import com.comrades.app.application.responseObjects.ListResultDto;
import com.comrades.app.application.responseObjects.SingleResultDto;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

public interface IAirplaneQuery {
    ListResultDto<AirplaneDto> findAll() throws URISyntaxException, IOException, InterruptedException;

    SingleResultDto<AirplaneDto> findById(UUID id);
}
