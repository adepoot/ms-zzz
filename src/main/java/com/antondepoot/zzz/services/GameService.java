package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.GameRepository;
import com.antondepoot.zzz.domain.entities.Game;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private final Season currentSeason;
    private final GameRepository gameRepository;

    public GameService(final AppProperties appProperties, final GameRepository gameRepository) {
        currentSeason = appProperties.getSeason();
        this.gameRepository = gameRepository;
    }

    public List<Game> getGamesFor(final UUID playerId) {
        return this.gameRepository.findAllGamesForPlayer(playerId, currentSeason);
    }

}
