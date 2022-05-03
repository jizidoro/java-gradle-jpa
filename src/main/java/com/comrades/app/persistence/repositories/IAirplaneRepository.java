package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.data.repository.CrudRepository;


public interface IAirplaneRepository extends CrudRepository<Airplane, Integer> {

    Airplane findById(int id);
}
