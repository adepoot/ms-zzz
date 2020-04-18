package com.antondepoot.zzz.domain;

import com.antondepoot.zzz.domain.entities.Player;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository {

    Optional<Player> findByIdAndDeletedAtIsNull(final UUID id);
}
