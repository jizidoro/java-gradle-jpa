package com.comrades.app.core.airplane.usecases;

import com.comrades.app.core.bases.UseCase;
import com.comrades.app.domain.models.Airplane;
import com.comrades.app.persistence.repositories.AirplaneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class UcAirplaneCreate extends UseCase<Airplane> {

    @Autowired
    private AirplaneRepository _airplaneRepository;

    private Airplane airplane;

    public UcAirplaneCreate(Airplane airplaneInput) {
        super();
        airplane = airplaneInput;
    }
    
    @Override
    protected Airplane execute() throws Exception {
        var teste = _airplaneRepository.save(airplane);
        return teste;
    }
}
