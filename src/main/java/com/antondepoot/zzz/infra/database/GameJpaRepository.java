package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.entities.Game;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface GameJpaRepository extends JpaRepository<Game, UUID> {

    List<Game> findGamesByDate_AfterAndDate_Before(final Instant start, final Instant end, final Sort sort);

    List<Game> findGamesByPlayers_IdAndDate_AfterAndDate_Before(
            final UUID id, final Instant start, final Instant end, final Sort sort);

}
