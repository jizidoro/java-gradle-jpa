//package com.comrades.app.application.services.airplane.commands;
//
//import com.comrades.app.application.mappers.AirplaneMapper;
//import com.comrades.app.application.services.airplane.IAirplaneCommand;
//import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
//import com.comrades.app.core.airplane.usecases.UcAirplaneCreate;
//import com.comrades.app.core.airplane.usecases.UcAirplaneDelete;
//import com.comrades.app.core.airplane.usecases.UcAirplaneEdit;
//import com.comrades.app.core.bases.UseCaseFacade;
//import com.comrades.app.persistence.repositories.AirplaneRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//
//@Service
//@RequiredArgsConstructor
//public class AirplaneCommand implements IAirplaneCommand {
//
//    private final UseCaseFacade facade;
//
//    @Autowired
//    private AirplaneRepository _airplaneRepository;
//
//    public Integer save(AirplaneDto airplane) {
//        var result = AirplaneMapper.INSTANCE.toAirplane(airplane);
//        var uc = new UcAirplaneCreate(result);
//        return facade.execute(uc);
//    }
//
//    public Integer update(AirplaneDto airplane) {
//        var result = AirplaneMapper.INSTANCE.toAirplane(airplane);
//        var uc = new UcAirplaneEdit(result);
//        return facade.execute(uc);
//    }
//
//    public Integer delete(UUID id) {
//        var uc = new UcAirplaneDelete(id);
//        return facade.execute(uc);
//    }
//}
