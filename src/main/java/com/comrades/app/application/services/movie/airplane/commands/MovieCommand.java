package com.comrades.app.application.services.movie.movie.commands;

import com.comrades.app.application.mappers.MovieMapper;
import com.comrades.app.application.services.movie.movie.IMovieCommand;
import com.comrades.app.application.services.movie.movie.dtos.MovieDto;
import com.comrades.app.core.movie.usecases.UcMovieCreate;
import com.comrades.app.core.movie.usecases.UcMovieDelete;
import com.comrades.app.core.movie.usecases.UcMovieEdit;
import com.comrades.app.core.bases.UseCaseFacade;
import com.comrades.app.persistence.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class MovieCommand implements IMovieCommand {

    private final UseCaseFacade facade;

    @Autowired
    private MovieRepository _movieRepository;

    public Integer save(MovieDto movie) {
        var result = MovieMapper.INSTANCE.toMovie(movie);
        var uc = new UcMovieCreate(result);
        return facade.execute(uc);
    }

    public Integer update(MovieDto movie) {
        var result = MovieMapper.INSTANCE.toMovie(movie);
        var uc = new UcMovieEdit(result);
        return facade.execute(uc);
    }

    public Integer delete(UUID id) {
        var uc = new UcMovieDelete(id);
        return facade.execute(uc);
    }
}
