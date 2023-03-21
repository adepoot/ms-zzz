package com.antondepoot.zzz.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public enum Season {
    SEASON_2020_2021(Instant.parse("2020-09-01T00:00:00.000Z"), Instant.parse("2021-08-31T00:00:00.000Z")),
    SEASON_2021_2022(Instant.parse("2021-09-01T00:00:00.000Z"), Instant.parse("2022-08-31T00:00:00.000Z")),
    SEASON_2022_2023(Instant.parse("2022-09-01T00:00:00.000Z"), Instant.parse("2023-08-31T00:00:00.000Z"));

    final Instant start;
    final Instant end;
}
