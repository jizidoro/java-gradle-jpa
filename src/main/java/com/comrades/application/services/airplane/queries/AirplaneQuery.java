package com.comrades.application.services.airplane.queries;

import com.comrades.application.mappers.AirplaneMapper;
import com.comrades.application.services.airplane.IAirplaneQuery;
import com.comrades.application.services.airplane.dtos.AirplaneDto;
import com.comrades.persistence.repositories.IAirplaneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class AirplaneQuery implements IAirplaneQuery {

    private final IAirplaneRepository _airplaneRepository;

    public List<AirplaneDto> findAll() throws URISyntaxException, IOException, InterruptedException {
        var result = _airplaneRepository.findAll();
        return StreamSupport.stream(result.spliterator(),false).map(x -> AirplaneMapper.INSTANCE.toAirplaneDto(x)).collect(Collectors.toList());
    }

    public AirplaneDto findById(int id) {
        var result = _airplaneRepository.findById(id);
        return AirplaneMapper.INSTANCE.toAirplaneDto(result);
    }
}
