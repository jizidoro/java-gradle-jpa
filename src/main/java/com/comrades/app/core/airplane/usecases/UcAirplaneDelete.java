package com.comrades.app.core.airplane.usecases;

import com.comrades.app.core.bases.UseCase;
import com.comrades.app.persistence.repositories.AirplaneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class UcAirplaneDelete extends UseCase<Integer> {

    @Autowired
    private AirplaneRepository _airplaneRepository;

    private Long id;

    public UcAirplaneDelete(Long airplaneId) {
        super();
        id = airplaneId;
    }

    @Override
    protected Integer execute() throws Exception {
        var result = _airplaneRepository.findById(id);

        return _airplaneRepository.delete(result.get().getId());
    }
}
