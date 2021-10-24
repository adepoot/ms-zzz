package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.GameRepository;
import com.antondepoot.zzz.domain.entities.Game;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class DatabaseGameRepository implements GameRepository {

    private static final Sort SORT = Sort.by(Sort.Direction.ASC, "date");

    private final GameJpaRepository repository;

    public DatabaseGameRepository(final GameJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Game> findAllGamesForPlayer(UUID id, Season season) {
        return this.repository.findGamesByPlayers_IdAndDate_AfterAndDate_Before(
                id, season.getStart(), season.getEnd(), SORT);
    }
}
