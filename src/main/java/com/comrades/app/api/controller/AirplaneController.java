package com.comrades.app.api.controller;


import com.comrades.app.application.services.airplane.IAirplaneCommand;
import com.comrades.app.application.services.airplane.IAirplaneQuery;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("Airplanes")
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
    @Operation(tags = {"Airplane"})
    public AirplaneDto findById(@PathVariable Long id) {
        try {
            return _airplaneQuery.findById(id);
        } catch (Exception ex) {
            return new AirplaneDto();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = {"Airplane"})
    public Integer save(@RequestBody AirplaneDto airplane) {
        try {
            return _airplaneCommand.save(airplane);
        } catch (Exception ex) {
            return 0;
        }
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = {"Airplane"})
    public Integer update(@PathVariable int id, @RequestBody AirplaneDto airplane) {
        try {
            return _airplaneCommand.update(airplane);
        } catch (Exception ex) {
            return 0;
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = {"Airplane"})
    public Integer delete(@PathVariable Long id) {
        try {
            return _airplaneCommand.delete(id);
        } catch (Exception ex) {
            return 0;
        }
    }

}
