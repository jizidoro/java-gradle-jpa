package com.comrades.app.application.services.airplane.queries;

import com.comrades.app.application.mappers.AirplaneMapper;
import com.comrades.app.application.services.airplane.IAirplaneQuery;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import com.comrades.app.persistence.repositories.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AirplaneQuery implements IAirplaneQuery {

    private final AirplaneRepository _airplaneRepository;

    public List<AirplaneDto> findAll() throws URISyntaxException, IOException, InterruptedException {
        var result = _airplaneRepository.findAll();
        return StreamSupport.stream(result.spliterator(),false).map(x -> AirplaneMapper.INSTANCE.toAirplaneDto(x)).collect(Collectors.toList());
    }

    public AirplaneDto findById(Long id) {
        var result = _airplaneRepository.findById(id);
        return AirplaneMapper.INSTANCE.toAirplaneDto(result.get());
    }
}
