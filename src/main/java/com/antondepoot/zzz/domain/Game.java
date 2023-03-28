package com.antondepoot.zzz.domain;

import lombok.Builder;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Builder
public record Game(UUID id, Instant date, Team homeTeam, Team awayTeam, int homeScore, int awayScore,
                   Collection<Player> players, Collection<Goal> goals, Collection<Save> saves) {

}
