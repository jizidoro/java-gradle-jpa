package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.stereotype.Repository;

@Repository
public class AirplaneRepository extends HashMapRepository<Airplane, Long>{

    public AirplaneRepository() {
        super(Airplane.class);
    }


    @Override
    <S extends Airplane> Long getEntityId(S entity) {
        return null;
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }
}
