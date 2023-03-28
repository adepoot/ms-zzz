package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository {

    Optional<Player> findById(final UUID id);

    List<Player> findAll(final Season season);

    List<Goal> findAllGoalsForPlayer(final UUID id, final Season season);

    List<Goal> findAllAssistsForPlayer(final UUID id, final Season season);

    List<Save> findAllSavesForPlayer(final UUID id, final Season season);

}
