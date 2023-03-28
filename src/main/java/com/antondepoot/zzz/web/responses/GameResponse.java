package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.Game;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Value
@Builder
public class GameResponse {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    @JsonProperty("id")
    UUID id;

    @JsonProperty("date")
    String date;

    @JsonProperty("home_team")
    String homeTeam;

    @JsonProperty("away_team")
    String awayTeam;

    @JsonProperty("home_score")
    int homeScore;

    @JsonProperty("away_score")
    int awayScore;

    public static GameResponse from(final Game game) {
        return GameResponse.builder()
                .id(game.id())
                .date(DATE_FORMATTER.format(Date.from(game.date())))
                .homeTeam(game.homeTeam().name())
                .awayTeam(game.awayTeam().name())
                .homeScore(game.homeScore())
                .awayScore(game.awayScore())
                .build();
    }

}
