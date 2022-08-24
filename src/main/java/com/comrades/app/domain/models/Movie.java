package com.comrades.app.domain.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table("movi_movie")
public class Movie {

    @Id
    @With
    @Column("movi_uuid_movie")
    private UUID id;

    @Column("movi_tx_year")
    private String year;

    @Column("movi_tx_title")
    private String title;

    @Column("movi_tx_studios")
    private String studios;

    @Column("movi_tx_producers")
    private String producers;

    @Column("movi_tx_winner")
    private String winner;

}
