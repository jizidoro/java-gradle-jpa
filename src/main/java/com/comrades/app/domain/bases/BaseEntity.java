package com.comrades.app.domain.bases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {
    public @Id Long id;
    public UUID key;
    public String value;

}
