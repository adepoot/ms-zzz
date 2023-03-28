package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.Player;
import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.Season;
import com.antondepoot.zzz.infra.database.entities.PlayerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DatabasePlayerRepository implements PlayerRepository {

    private static final Sort SORT = Sort.by(Sort.Direction.ASC, "firstName", "lastName");

    private final PlayerJpaRepository playerJpaRepository;

    public DatabasePlayerRepository(PlayerJpaRepository playerJpaRepository) {
        this.playerJpaRepository = playerJpaRepository;
    }

    @Override
    public Optional<Player> findById(final UUID id) {
        return this.playerJpaRepository.findByIdAndDeletedAtIsNull(id)
                .map(PlayerEntity::toPlayer);
    }

    @Override
    public List<Player> findAll(final Season season) {
        return this.playerJpaRepository
                .findDistinctPlayersByDeletedAtIsNullAndGamesDate_AfterAndGamesDate_Before(season.getStart(), season.getEnd(), SORT)
                .stream()
                .map(PlayerEntity::toPlayer)
                .toList();
    }

}
