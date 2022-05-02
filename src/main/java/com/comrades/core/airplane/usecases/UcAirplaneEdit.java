package com.comrades.core.airplane.usecases;

import com.comrades.core.bases.UseCase;
import com.comrades.domain.models.Airplane;
import com.comrades.persistence.repositories.IAirplaneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class UcAirplaneEdit extends UseCase<Airplane> {

    @Autowired
    private IAirplaneRepository _airplaneRepository;

    private Airplane airplane;

    public UcAirplaneEdit(Airplane airplaneInput) {
        super();
        airplane = airplaneInput;
    }

    @Override
    protected Airplane execute() throws Exception {
        var result = _airplaneRepository.findById(airplane.getId());
        return _airplaneRepository.save(result.get());
    }
}
