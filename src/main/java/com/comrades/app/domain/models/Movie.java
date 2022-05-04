package com.comrades.app.domain.models;

import java.time.LocalDate;

public record Movie(Integer id,
                    String name,
                    LocalDate releaseDate) {
}
