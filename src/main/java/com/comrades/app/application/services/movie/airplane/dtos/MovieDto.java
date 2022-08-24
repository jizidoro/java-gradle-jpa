package com.comrades.app.application.services.movie.movie.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private UUID id;

    @NotNull
    @NotEmpty
    private String code;

    @NotNull
    @NotEmpty
    private String model;

    @NotNull
    private Integer passengerQuantity;

    private Date registerDate;

}
