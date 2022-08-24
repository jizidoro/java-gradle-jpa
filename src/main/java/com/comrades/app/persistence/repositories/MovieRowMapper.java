package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Movie(
                UUID.fromString(resultSet.getString("movi_uuid_movie")),
                resultSet.getString("movi_tx_year"),
                resultSet.getString("movi_tx_title"),
                resultSet.getString("movi_tx_studios"),
                resultSet.getString("movi_tx_producers"),
                resultSet.getString("movi_tx_winner")
        );
    }
}
