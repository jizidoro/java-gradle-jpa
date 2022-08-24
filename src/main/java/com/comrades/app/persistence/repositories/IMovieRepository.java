package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMovieRepository {
    List<Movie> findAll();
    int save(Movie movie);
    int edit(Movie movie);
    int delete(UUID id);
    Optional<Movie> findById(UUID id);
}
