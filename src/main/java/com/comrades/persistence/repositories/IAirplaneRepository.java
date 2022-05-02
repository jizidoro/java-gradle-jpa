package com.comrades.persistence.repositories;

import com.comrades.domain.models.Airplane;
import org.springframework.data.repository.CrudRepository;


public interface IAirplaneRepository extends CrudRepository<Airplane, Integer> {

    Airplane findById(int id);
}
