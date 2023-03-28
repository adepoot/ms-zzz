package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class StatisticsService {

    private final Season currentSeason;
    private final GameRepository gameRepository;
    private final GoalRepository goalRepository;
    private final SavesRepository savesRepository;

    public StatisticsService(
            final AppProperties appProperties,
            final GameRepository gameRepository,
            final GoalRepository goalRepository,
            final SavesRepository savesRepository) {
        this.currentSeason = appProperties.getSeason();
        this.gameRepository = gameRepository;
        this.goalRepository = goalRepository;
        this.savesRepository = savesRepository;
    }

    @Transactional
    public List<Game> getGamesFor(final UUID playerId) {
        return this.gameRepository.findAllGamesForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Goal> getGoalsFor(final UUID playerId) {
        // TODO: use playerRepository instead of goalRepository
        return this.goalRepository.findAllGoalsForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Goal> getAssistsFor(final UUID playerId) {
        return this.goalRepository.findAllAssistsForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Save> getSavesFor(final UUID playerId) {
        return this.savesRepository.findAllSavesForPlayer(playerId, currentSeason);
    }

}
