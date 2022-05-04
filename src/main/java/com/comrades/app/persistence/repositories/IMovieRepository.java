package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
}
