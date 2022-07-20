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

    @JsonProperty("matches_played")
    int matchesPlayed;

    @JsonProperty("matches_won")
    int matchesWon;

    @JsonProperty("matches_drawn")
    int matchesDrawn;

    @JsonProperty("matches_lost")
    int matchesLost;

    @JsonProperty("goals_for")
    int goalsFor;

    @JsonProperty("goals_against")
    int goalsAgainst;

    @JsonProperty("goals_difference")
    int goalsDifference;

    @JsonProperty("points_per_match")
    double pointsPerMatch;
}
