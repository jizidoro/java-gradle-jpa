package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AirplaneRowMapper implements RowMapper<Airplane> {
    @Override
    public Airplane mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Airplane(
                UUID.fromString(resultSet.getString("airp_uuid_airplane")),
                resultSet.getString("airp_tx_code"),
                resultSet.getString("airp_tx_model"),
                resultSet.getInt("airp_qt_passenger"),
                resultSet.getDate("airp_dt_register")
        );
    }
}
