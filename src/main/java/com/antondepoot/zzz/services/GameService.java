package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.GameRepository;
import com.antondepoot.zzz.domain.entities.Game;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private static final Season CURRENT_SEASON = Season.SEASON_2021_2022;

    private final GameRepository gameRepository;

    public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGamesFor(final UUID playerId) {
        return this.gameRepository.findAllGamesForPlayer(playerId, CURRENT_SEASON);
    }

}
