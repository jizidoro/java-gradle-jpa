package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;

import java.util.List;
import java.util.Optional;

public interface IAirplaneRepository {
    List<Airplane> findAll();
    int save(Airplane movie);
    int delete(Long id);
    Optional<Airplane> findById(Long id);
}
