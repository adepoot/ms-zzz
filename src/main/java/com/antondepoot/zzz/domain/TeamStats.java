package com.antondepoot.zzz.domain;

public record TeamStats(String name, int position, int points, int gamesPlayed, int gamesWon, int gamesDrawn,
                        int gamesLost, int goalsFor, int goalsAgainst, int goalsDifference, double pointsPerGame) {
}
