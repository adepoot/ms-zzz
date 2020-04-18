package com.antondepoot.zzz.database;

import com.antondepoot.zzz.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerJpaRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByIdAndDeletedAtIsNull(final UUID id);
}
