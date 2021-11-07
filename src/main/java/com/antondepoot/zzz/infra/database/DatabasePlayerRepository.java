package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.domain.entities.Season;
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
        return this.playerJpaRepository.findByIdAndDeletedAtIsNull(id);
    }

    @Override
    public List<Player> findAll(final Season season) {
        return this.playerJpaRepository
                .findDistinctPlayersByDeletedAtIsNullAndGames_DateAfterAndGames_DateBefore(season.getStart(), season.getEnd(), SORT);
    }

}
