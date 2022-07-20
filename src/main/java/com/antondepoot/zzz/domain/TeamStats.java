package com.antondepoot.zzz.domain;

import lombok.Value;

@Value
public class TeamStats {
    String name;
    int position;
    int points;
    int matchesPlayed;
    int matchesWon;
    int matchesDrawn;
    int matchesLost;
    int goalsFor;
    int goalsAgainst;
    int goalsDifference;
    double pointsPerMatch;
}
