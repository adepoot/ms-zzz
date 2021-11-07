package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.entities.Game;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GameResponse {

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
                .homeTeam(game.getHomeTeam().getName())
                .awayTeam(game.getAwayTeam().getName())
                .homeScore(game.getHomeScore())
                .awayScore(game.getAwayScore())
                .build();
    }

}
