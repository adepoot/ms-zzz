package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.infra.database.entities.SavesEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface SavesJpaRepository extends JpaRepository<SavesEntity, UUID> {

    List<SavesEntity> findSavesByKeeper_IdAndGame_Date_AfterAndGame_Date_Before(
            final UUID id, final Instant start, final Instant end, final Sort sort);

}
