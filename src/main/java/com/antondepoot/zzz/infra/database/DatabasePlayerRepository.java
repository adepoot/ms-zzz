package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.*;
import com.antondepoot.zzz.infra.database.entities.GoalEntity;
import com.antondepoot.zzz.infra.database.entities.PlayerEntity;
import com.antondepoot.zzz.infra.database.entities.SavesEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DatabasePlayerRepository implements PlayerRepository {

    private static final Sort SORT_PLAYERS = Sort.by(Sort.Direction.ASC, "firstName", "lastName");
    private static final Sort SORT_GOALS = Sort.by(Sort.Direction.ASC, "assister_id");
    private static final Sort SORT_SAVES = Sort.by(Sort.Direction.ASC, "game.date");

    private final PlayerJpaRepository playerJpaRepository;
    private final GoalJpaRepository goalJpaRepository;
    private final SavesJpaRepository savesJpaRepository;

    public DatabasePlayerRepository(PlayerJpaRepository playerJpaRepository, GoalJpaRepository goalJpaRepository, SavesJpaRepository savesJpaRepository) {
        this.playerJpaRepository = playerJpaRepository;
        this.goalJpaRepository = goalJpaRepository;
        this.savesJpaRepository = savesJpaRepository;
    }

    @Override
    public Optional<Player> findById(final UUID id) {
        return this.playerJpaRepository.findByIdAndDeletedAtIsNull(id)
                .map(PlayerEntity::toPlayer);
    }

    @Override
    public List<Player> findAll(final Season season) {
        return this.playerJpaRepository
                .findDistinctPlayersByDeletedAtIsNullAndGamesDate_AfterAndGamesDate_Before(season.getStart(), season.getEnd(), SORT_PLAYERS)
                .stream()
                .map(PlayerEntity::toPlayer)
                .toList();
    }

    @Override
    public List<Goal> findAllGoalsForPlayer(final UUID id, final Season season) {
        return this.goalJpaRepository.findAllByScorerIdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT_GOALS)
                .stream()
                .map(GoalEntity::toGoal)
                .toList();
    }

    @Override
    public List<Goal> findAllAssistsForPlayer(UUID id, Season season) {
        return this.goalJpaRepository.findAllByAssisterIdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT_GOALS)
                .stream()
                .map(GoalEntity::toGoal)
                .toList();
    }

    @Override
    public List<Save> findAllSavesForPlayer(UUID id, Season season) {
        return this.savesJpaRepository.findSavesByKeeper_IdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT_SAVES)
                .stream()
                .map(SavesEntity::toSave)
                .toList();
    }

}
