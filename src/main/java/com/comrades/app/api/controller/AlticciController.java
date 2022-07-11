package com.comrades.app.api.controller;


import com.comrades.app.application.responses.SingleResultDto;
import com.comrades.app.application.services.alticci.IAlticciQuery;
import com.comrades.app.application.services.alticci.dtos.AlticciDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alticci")
@RequiredArgsConstructor
@SecurityScheme(
        name = "Basic Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class AlticciController {

    private final IAlticciQuery _alticciQuery;



    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = {"Alticci"})
    @GetMapping(value = {"/{inputValue}"})
    public SingleResultDto<AlticciDto> findById(@PathVariable(name = "inputValue") Long inputValue) {
        try {
            return _alticciQuery.findById(inputValue);
        } catch (Exception ex) {
            return new SingleResultDto<>(ex);
        }
    }

}
