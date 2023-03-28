package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.infra.database.entities.PlayerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, UUID> {

    Optional<PlayerEntity> findByIdAndDeletedAtIsNull(final UUID id);

    List<PlayerEntity> findDistinctPlayersByDeletedAtIsNullAndGamesDate_AfterAndGamesDate_Before(
            final Instant start, final Instant end, final Sort sort);

}
