package com.comrades.api.usecases.v1;


import com.comrades.application.services.airplane.IAirplaneCommand;
import com.comrades.application.services.airplane.IAirplaneQuery;
import com.comrades.application.services.airplane.dtos.AirplaneDto;
import com.comrades.domain.models.Airplane;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("Airplanes")
@Slf4j
@RequiredArgsConstructor
@SecurityScheme(
        name = "Basic Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class AirplaneController {

    private final IAirplaneCommand _airplaneCommand;
    private final IAirplaneQuery _airplaneQuery;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List all Airplanes",
            tags = {"Airplane"})
    public List<AirplaneDto> listAll() {
        try {
            return _airplaneQuery.findAll();
        } catch (Exception ex) {
            return Collections.<AirplaneDto>emptyList();
        }

    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = {"Airplane"})
    public AirplaneDto findById(@PathVariable int id) {
        try {
            return _airplaneQuery.findById(id);
        } catch (Exception ex) {
            return new AirplaneDto();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = {"Airplane"})
    public Airplane save(@Valid @RequestBody AirplaneDto airplane) {
        try {
            return _airplaneCommand.save(airplane);
        } catch (Exception ex) {
            return new Airplane();
        }
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            tags = {"Airplane"})
    public Boolean update(@PathVariable int id, @Valid @RequestBody AirplaneDto airplane) {
        try {
            return _airplaneCommand.update(airplane);
        } catch (Exception ex) {
            return false;
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            tags = {"Airplane"})
    public Boolean delete(@PathVariable int id) {
        try {
            return _airplaneCommand.delete(id);
        } catch (Exception ex) {
            return false;
        }
    }

}
