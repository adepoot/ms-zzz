package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.Goal;
import com.antondepoot.zzz.domain.GoalRepository;
import com.antondepoot.zzz.domain.Season;
import com.antondepoot.zzz.infra.database.entities.GoalEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class DatabaseGoalRepository implements GoalRepository {

    private static final Sort SORT = Sort.by(Sort.Direction.ASC, "assister_id");

    private final GoalJpaRepository repository;

    public DatabaseGoalRepository(final GoalJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Goal> findAllGoalsForPlayer(final UUID id, final Season season) {
        return this.repository.findAllByScorerIdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT)
                .stream()
                .map(GoalEntity::toGoal)
                .toList();
    }

    @Override
    public List<Goal> findAllAssistsForPlayer(UUID id, Season season) {
        return this.repository.findAllByAssisterIdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT)
                .stream()
                .map(GoalEntity::toGoal)
                .toList();
    }
}
