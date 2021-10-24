package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.entities.Saves;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface SavesJpaRepository extends JpaRepository<Saves, UUID> {

    List<Saves> findSavesByKeeper_IdAndGame_Date_AfterAndGame_Date_Before(
            final UUID id, final Instant start, final Instant end, final Sort sort);

}
