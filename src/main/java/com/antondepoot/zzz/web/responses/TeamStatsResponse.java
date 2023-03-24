package com.antondepoot.zzz.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TeamStatsResponse {
    String name;
    int position;
    int points;

    @JsonProperty("games_played")
    int gamesPlayed;

    @JsonProperty("games_won")
    int gamesWon;

    @JsonProperty("games_drawn")
    int gamesDrawn;

    @JsonProperty("games_lost")
    int gamesLost;

    @JsonProperty("goals_for")
    int goalsFor;

    @JsonProperty("goals_against")
    int goalsAgainst;

    @JsonProperty("goals_difference")
    int goalsDifference;

    @JsonProperty("points_per_game")
    double pointsPerGame;

}
