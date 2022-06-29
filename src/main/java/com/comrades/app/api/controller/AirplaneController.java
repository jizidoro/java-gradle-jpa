package com.comrades.app.api.controller;


import com.comrades.app.application.responseObjects.ListResultDto;
import com.comrades.app.application.responseObjects.SingleResultDto;
import com.comrades.app.application.services.airplane.IAirplaneCommand;
import com.comrades.app.application.services.airplane.IAirplaneQuery;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/airplane")
@RequiredArgsConstructor
@SecurityScheme(
        name = "Basic Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class AirplaneController {

    private final IAirplaneCommand _airplaneCommand;
    private final IAirplaneQuery _airplaneQuery;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List all Airplanes",
            tags = {"Airplane"})
    public ListResultDto<AirplaneDto> getAll(@RequestParam("pageNumber") Optional<Integer> pageNumber, @RequestParam("pageSize")Optional<Integer> pageSize) {
        try {
            return _airplaneQuery.findAll();
        } catch (Exception ex) {
            return new ListResultDto<>(ex);
        }
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = {"Airplane"})
    public SingleResultDto<AirplaneDto> findById(@PathVariable UUID id) {
        try {
            return _airplaneQuery.findById(id);
        } catch (Exception ex) {
            return new SingleResultDto<>(ex);
        }
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = {"Airplane"})
    public SingleResultDto<AirplaneDto> save(@RequestBody AirplaneDto airplane) {
        try {
            var result =  _airplaneCommand.save(airplane);
            return new SingleResultDto<>(result);
        } catch (Exception ex) {
            return new SingleResultDto<>(ex);
        }
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = {"Airplane"})
    public SingleResultDto<AirplaneDto> update(@RequestBody AirplaneDto airplane) {
        try {
            var result =  _airplaneCommand.update(airplane);
            return new SingleResultDto<>(result);
        } catch (Exception ex) {
            return new SingleResultDto<>(ex);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = {"Airplane"})
    public SingleResultDto<AirplaneDto> delete(@PathVariable UUID id) {
        try {
            var result = _airplaneCommand.delete(id);
            return new SingleResultDto<>(result);
        } catch (Exception ex) {
            return new SingleResultDto<>(ex);
        }
    }
}
