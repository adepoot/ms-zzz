package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.GameRepository;
import com.antondepoot.zzz.domain.entities.Game;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final Season currentSeason;
    private final GameRepository repository;

    public GameService(final AppProperties appProperties, final GameRepository repository) {
        this.currentSeason = appProperties.getSeason();
        this.repository = repository;
    }

    public List<Game> getGames() {
        return this.repository.findAll(currentSeason);
    }

}
