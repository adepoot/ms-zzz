package com.antondepoot.zzz.database;

import com.antondepoot.zzz.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByIdAndDeletedAtIsNull(final UUID id);
}
