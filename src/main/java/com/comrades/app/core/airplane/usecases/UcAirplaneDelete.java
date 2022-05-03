package com.comrades.app.core.airplane.usecases;

import com.comrades.app.core.bases.UseCase;
import com.comrades.app.domain.models.Airplane;
import com.comrades.app.persistence.repositories.IAirplaneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class UcAirplaneDelete extends UseCase<Airplane> {

    @Autowired
    private IAirplaneRepository _airplaneRepository;

    private int id;

    public UcAirplaneDelete(int airplaneId) {
        super();
        id = airplaneId;
    }

    @Override
    protected Airplane execute() throws Exception {
        var result = _airplaneRepository.findById(id);

        _airplaneRepository.delete(result);

        return result;
    }
}
