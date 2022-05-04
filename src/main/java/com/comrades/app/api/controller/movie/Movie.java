package com.comrades.app.api.controller.movie;

import java.time.LocalDate;

public record Movie(Integer id,
                    String name,
                    LocalDate releaseDate) {
}
