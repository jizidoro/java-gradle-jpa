package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AirplaneRepository implements IAirplaneRepository {

    private final JdbcTemplate jdbcTemplate;

    public AirplaneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Airplane> findAll() {
        var sql = """
                SELECT airp_uuid_airplane, airp_tx_code, airp_tx_model, airp_qt_passenger, airp_dt_register
                FROM airp_airplane;
                """;
        return jdbcTemplate.query(sql, new AirplaneRowMapper());
    }

    @Override
    public int save(Airplane airplane) {
        try {
            var sql = """
                    INSERT INTO airp_airplane(airp_uuid_airplane, airp_tx_code, airp_tx_model, airp_qt_passenger, airp_dt_register)
                    VALUES (?, ?, ?, ?, ?);
                    """;
            return jdbcTemplate.update(
                    sql,
                    airplane.getId() ,airplane.getCode(), airplane.getModel(), airplane.getPassengerQuantity(), airplane.getRegisterDate()
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public int edit(Airplane airplane) {
        try {
            var sql = """
                    update airp_airplane set
                    airp_tx_code = ?,
                    airp_tx_model = ?,
                    airp_qt_passenger = ?
                    where airp_uuid_airplane = ?
                    """;
            return jdbcTemplate.update(
                    sql,
                    airplane.getCode(), airplane.getModel(), airplane.getPassengerQuantity(), airplane.getId()
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
                    DELETE FROM airp_airplane   
                    WHERE airp_uuid_airplane = ?
                    """;
            return jdbcTemplate.update(sql, id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public Optional<Airplane> findById(UUID id) {
        var sql = """
                SELECT airp_uuid_airplane, airp_tx_code, airp_tx_model, airp_qt_passenger, airp_dt_register
                FROM airp_airplane
                WHERE airp_uuid_airplane = ?
                """;

        return jdbcTemplate.query(sql, new AirplaneRowMapper(), id)
                .stream()
                .findFirst();
    }

}
