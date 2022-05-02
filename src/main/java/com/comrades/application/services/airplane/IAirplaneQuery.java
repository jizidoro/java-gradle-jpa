package com.comrades.application.services.airplane;

import com.comrades.application.services.airplane.dtos.AirplaneDto;



import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IAirplaneQuery {
    List<AirplaneDto> findAll() throws URISyntaxException, IOException, InterruptedException;

    AirplaneDto findById(int id);
}
