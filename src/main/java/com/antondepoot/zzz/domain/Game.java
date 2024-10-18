package com.antondepoot.zzz.domain;

import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record Game(UUID id, Instant date, Team homeTeam, Team awayTeam, int homeScore, int awayScore,
                   List<Player> players, List<Goal> goals, List<Save> saves) {

}
