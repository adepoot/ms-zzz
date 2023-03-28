package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository {

    Optional<Player> findById(final UUID id);

    List<Player> findAll(final Season season);

    // TODO: use playerRepo instead of goalRepo
//    List<Goal> findGoalsFor(final UUID playerId, final Season season);

}
