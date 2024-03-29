package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository {

    List<Game> findAll(final Season season);

    List<Game> findAllGamesForPlayer(final UUID id, final Season season);

}
