package com.comrades.app.application.services.movie;

import com.comrades.app.application.services.movie.dtos.MovieDto;

import java.util.List;
import java.util.UUID;

public interface IMovieCommand {
    Integer save(MovieDto movie);

    int[] saveBatch(List<MovieDto> movies);

    Integer update(MovieDto movie);

    Integer delete(UUID id);
}
