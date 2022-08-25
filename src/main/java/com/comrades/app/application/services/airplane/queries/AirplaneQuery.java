//package com.comrades.app.application.services.airplane.queries;
//
//import com.comrades.app.application.mappers.AirplaneMapper;
//import com.comrades.app.application.responseObjects.ListResultDto;
//import com.comrades.app.application.responseObjects.SingleResultDto;
//import com.comrades.app.application.services.airplane.IAirplaneQuery;
//import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
//import com.comrades.app.persistence.repositories.AirplaneRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.UUID;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//@Service
//@RequiredArgsConstructor
//public class AirplaneQuery implements IAirplaneQuery {
//
//    private final AirplaneRepository _airplaneRepository;
//
//    public ListResultDto<AirplaneDto> findAll() throws URISyntaxException, IOException, InterruptedException {
//        var result = _airplaneRepository.findAll();
//        var response = StreamSupport.stream(result.spliterator(),false)
//                .map(x -> AirplaneMapper.INSTANCE.toAirplaneDto(x)).collect(Collectors.toList());
//
//        return new ListResultDto<AirplaneDto>(response);
//    }
//
//    public SingleResultDto<AirplaneDto> findById(UUID id) {
//        var result = _airplaneRepository.findById(id);
//        var response = AirplaneMapper.INSTANCE.toAirplaneDto(result.get());
//        return new SingleResultDto<AirplaneDto>(response);
//    }
//}
