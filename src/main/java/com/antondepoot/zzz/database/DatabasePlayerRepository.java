package com.antondepoot.zzz.database;

import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.entities.Player;

import java.util.Optional;
import java.util.UUID;

public class DatabasePlayerRepository implements PlayerRepository {

    private final PlayerJpaRepository playerJpaRepository;

    public DatabasePlayerRepository(PlayerJpaRepository playerJpaRepository) {
        this.playerJpaRepository = playerJpaRepository;
    }

    @Override
    public Optional<Player> findByIdAndDeletedAtIsNull(UUID id) {
        return this.playerJpaRepository.findByIdAndDeletedAtIsNull(id);
    }
}
