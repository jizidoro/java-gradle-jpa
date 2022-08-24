package com.comrades.app.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.comrades.app.api.controller.AirplaneController;
import com.comrades.app.application.responseObjects.ListResultDto;
import com.comrades.app.application.services.airplane.IAirplaneCommand;
import com.comrades.app.application.services.airplane.IAirplaneQuery;
import com.comrades.app.application.services.airplane.dtos.AirplaneDto;

import com.comrades.app.application.services.movie.dtos.MovieDto;
import com.comrades.app.domain.models.Movie;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(value = AirplaneController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class AirplaneControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IAirplaneCommand _airplaneCommand;

    @MockBean
    private IAirplaneQuery _airplaneQuery;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenAirplanes_whenGetAirplanes_thenReturnJsonArray() throws Exception {
        AirplaneDto boeing = new AirplaneDto(
                UUID.fromString("063f44b8-df8b-4f96-889a-75b9d67c546f"),
                "123",
                "boing",
                123,
                new Date());
        AirplaneDto mig = new AirplaneDto(
                UUID.fromString("84ceb636-bbc5-49ed-8b5f-512931f649ec"),
                "123",
                "mig",
                123,
                new Date());


        ListResultDto<AirplaneDto> allAirplanes = new ListResultDto<AirplaneDto>(Arrays.asList(boeing, mig));

        given(_airplaneQuery.findAll()).willReturn(allAirplanes);


        mvc.perform(get("/api/v1/airplane/get-all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].model", is(boeing.getModel())))
                .andExpect(jsonPath("$.data[1].model", is(mig.getModel())));
        verify(_airplaneQuery, VerificationModeFactory.times(1)).findAll();
        reset(_airplaneQuery);
    }

    @Test
    public void csvToJson() throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper
                .schemaFor(MovieDto.class)
                .withColumnSeparator(';')
                .withHeader();

        MappingIterator<MovieDto> orderLines = csvMapper.readerFor(MovieDto.class)
                .with(csvSchema)
                .readValues(new File("src/main/resources/movielist.csv"));

        var teste = orderLines.readAll();
        var oto = teste.get(1);
    }


}