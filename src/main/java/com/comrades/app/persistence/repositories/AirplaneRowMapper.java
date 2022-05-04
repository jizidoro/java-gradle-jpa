package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AirplaneRowMapper implements RowMapper<Airplane> {
    @Override
    public Airplane mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Airplane(
                resultSet.getLong("airp_sq_airplane"),
                resultSet.getString("airp_tx_codigo"),
                resultSet.getString("airp_tx_modelo"),
                resultSet.getInt("airp_qt_passageiro"),
                LocalDate.parse(resultSet.getString("airp_dt_registro"))
        );
    }
}
