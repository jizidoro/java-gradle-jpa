package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Airplane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AirplaneRepository implements IAirplaneRepository {

    private final JdbcTemplate jdbcTemplate;

    public AirplaneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Airplane> findAll() {
        var sql = """
                SELECT airp_sq_airplane, airp_tx_codigo, airp_tx_modelo, airp_qt_passageiro, airp_dt_registro
                FROM airp_airplane;
                 """;
        return jdbcTemplate.query(sql, new AirplaneRowMapper());
    }

    @Override
    public int save(Airplane airplane) {
        var sql = """
                INSERT INTO airplane(airp_tx_codigo, airp_tx_modelo, airp_qt_passageiro, airp_dt_registro)
                VALUES (?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                airplane.getCodigo(), airplane.getModelo()
        );
    }

    @Override
    public int delete(Long id) {
        var sql = """
                DELETE FROM airp_airplane   
                WHERE airp_sq_airplane = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Airplane> findById(Long id) {
        var sql = """
                SELECT airp_sq_airplane, airp_tx_codigo, airp_dt_registro
                FROM airp_airplane
                WHERE airp_sq_airplane = ?
                 """;
        return jdbcTemplate.query(sql, new AirplaneRowMapper(), id)
                .stream()
                .findFirst();
    }

}
