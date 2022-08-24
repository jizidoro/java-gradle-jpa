package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Movie;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MovieRepository implements IMovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll() {
        var sql = """
                SELECT movi_uuid_movie, movi_tx_year, movi_tx_title, movi_tx_studios,
                    movi_tx_producers, movi_tx_winner
                FROM movi_movie;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int save(Movie movie) {
        try {
            var sql = """
                    INSERT INTO movi_movie(movi_uuid_movie, movi_tx_year, movi_tx_title, movi_tx_studios,
                    movi_tx_producers, movi_tx_winner)
                    VALUES (?, ?, ?, ?, ?, ?);
                    """;
            return jdbcTemplate.update(
                    sql,
                    movie.getId() ,movie.getYear(), movie.getTitle(), movie.getStudios(),
                    movie.getProducers(), movie.getWinner()

            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    public int[] saveBatch(List<Movie> movie){

        try {
            var sql = """
                    INSERT INTO movi_movie(movi_uuid_movie, movi_tx_year, movi_tx_title, movi_tx_studios,
                    movi_tx_producers, movi_tx_winner)
                    VALUES (?, ?, ?, ?, ?, ?);
                    """;

            return this.jdbcTemplate.batchUpdate(
                    sql,
                    new BatchPreparedStatementSetter() {
                        public void setValues(PreparedStatement ps, int i)
                                throws SQLException {
                            ps.setObject(1, UUID.randomUUID());
                            ps.setString(2, movie.get(i).getYear());
                            ps.setString(3, movie.get(i).getTitle());
                            ps.setString(4, movie.get(i).getStudios());
                            ps.setString(5, movie.get(i).getProducers());
                            ps.setString(6, movie.get(i).getWinner());
                        }

                        public int getBatchSize() {
                            return movie.size();
                        }
                    });
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public int edit(Movie movie) {
        try {
            var sql = """
                    update movi_movie set
                    movi_tx_year = ?,
                    movi_tx_title = ?,
                    movi_tx_studios = ?
                    where movi_uuid_movie = ?
                    """;
            return jdbcTemplate.update(
                    sql,
                    movie.getYear(), movie.getTitle(), movie.getStudios(), movie.getId()
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }


    @Override
    public int delete(UUID id) {
        try {
            var sql = """
                    DELETE FROM movi_movie   
                    WHERE movi_uuid_movie = ?
                    """;
            return jdbcTemplate.update(sql, id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public Optional<Movie> findById(UUID id) {
        var sql = """
                SELECT movi_uuid_movie, movi_tx_year, movi_tx_title, movi_tx_studios,
                    movi_tx_producers, movi_tx_winner
                FROM movi_movie
                WHERE movi_uuid_movie = ?
                """;

        return jdbcTemplate.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }

}
