package com.comrades.app.domain.models;

import com.comrades.app.domain.bases.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table("airp_airplane")
public class Airplane extends BaseEntity {

    @Id
    @With
    @Column("airp_sq_airplane")
    private Long id;

    @NotNull
    @NotEmpty(message = "The name of this Airplane cannot be empty")
    @Column("airp_tx_codigo")
    private String codigo;

    @Column("airp_tx_modelo")
    private String modelo;

    @Column("airp_qt_passageiro")
    private Integer quantidadePassageiro;

    @Column("airp_dt_registro")
    private LocalDate dataRegistro;

}
