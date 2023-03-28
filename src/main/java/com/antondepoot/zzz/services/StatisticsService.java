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
    private final PlayerRepository playerRepository;

    public StatisticsService(
            final AppProperties appProperties,
            final GameRepository gameRepository,
            final PlayerRepository playerRepository) {
        this.currentSeason = appProperties.getSeason();
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    public List<Game> getGamesFor(final UUID playerId) {
        return this.gameRepository.findAllGamesForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Goal> getGoalsFor(final UUID playerId) {
        return this.playerRepository.findAllGoalsForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Goal> getAssistsFor(final UUID playerId) {
        return this.playerRepository.findAllAssistsForPlayer(playerId, currentSeason);
    }

    @Transactional
    public List<Save> getSavesFor(final UUID playerId) {
        return this.playerRepository.findAllSavesForPlayer(playerId, currentSeason);
    }

}
