package com.comrades.app.application.services.movie.movie;

import com.comrades.app.application.services.movie.movie.dtos.MovieDto;

import java.util.UUID;

public interface IMovieCommand {
    Integer save(MovieDto movie);

    Integer update(MovieDto movie);

    Integer delete(UUID id);
}
