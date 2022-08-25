//package com.comrades.app.core.airplane.usecases;
//
//import com.comrades.app.core.bases.UseCase;
//import com.comrades.app.domain.models.Airplane;
//import com.comrades.app.persistence.repositories.AirplaneRepository;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.Instant;
//import java.util.Date;
//
//
//@Getter
//@Setter
//public class UcAirplaneCreate extends UseCase<Integer> {
//
//    @Autowired
//    private AirplaneRepository _airplaneRepository;
//
//    private Airplane airplane;
//
//    public UcAirplaneCreate(Airplane airplaneInput) {
//        super();
//        airplane = airplaneInput;
//    }
//
//    @Override
//    protected Integer execute() throws Exception {
//        var date =Date.from(Instant.now());
//        airplane.setRegisterDate(date);
//        return _airplaneRepository.save(airplane);
//    }
//}
