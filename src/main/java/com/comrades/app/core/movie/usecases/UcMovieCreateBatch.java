package com.comrades.app.core.movie.usecases;

import com.comrades.app.core.bases.UseCase;
import com.comrades.app.domain.models.Movie;
import com.comrades.app.persistence.repositories.MovieRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Getter
@Setter
public class UcMovieCreateBatch extends UseCase<int[]> {

    @Autowired
    private MovieRepository _movieRepository;

    private List<Movie> movie;

    public UcMovieCreateBatch(List<Movie> movieInput) {
        super();
        movie = movieInput;
    }
    
    @Override
    protected int[] execute() throws Exception {
        return _movieRepository.saveBatch(movie);
    }
}
