package com.antondepoot.zzz.domain;

import com.antondepoot.zzz.domain.entities.Game;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository {

    List<Game> findAllGamesForPlayer(final UUID id, final Season season);

}
