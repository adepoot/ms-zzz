package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.Game;
import com.antondepoot.zzz.domain.GameRepository;
import com.antondepoot.zzz.domain.Season;
import com.antondepoot.zzz.infra.database.entities.GameEntity;
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
    public List<Game> findAll(Season season) {
        return repository.findGamesByDate_AfterAndDate_Before(season.getStart(), season.getEnd(), SORT).stream()
                .map(GameEntity::toBasicGame)
                .toList();
    }

    @Override
    public List<Game> findAllGamesForPlayer(UUID id, Season season) {
        return this.repository.findGamesByPlayers_IdAndDate_AfterAndDate_Before(
                id, season.getStart(), season.getEnd(), SORT).stream()
                .map(GameEntity::toBasicGame)
                .toList();
    }

}
