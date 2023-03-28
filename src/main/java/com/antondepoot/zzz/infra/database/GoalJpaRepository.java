package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.infra.database.entities.GoalEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface GoalJpaRepository extends JpaRepository<GoalEntity, UUID> {

    List<GoalEntity> findAllByScorerIdAndGame_Date_AfterAndGame_Date_Before(
            final UUID id, final Instant start, final Instant end, final Sort sort);

    List<GoalEntity> findAllByAssisterIdAndGame_Date_AfterAndGame_Date_Before(
            final UUID id, final Instant start, final Instant end, final Sort sort);

}
