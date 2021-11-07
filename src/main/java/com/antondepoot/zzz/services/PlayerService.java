package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.domain.entities.Season;
import com.antondepoot.zzz.domain.exceptions.PlayerNotFound;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    private final Season currentSeason;
    private final PlayerRepository playerRepository;

    public PlayerService(final AppProperties appProperties, final PlayerRepository playerRepository) {
        this.currentSeason = appProperties.getSeason();
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player getPlayer(final UUID id) {
        return this.playerRepository.findById(id).orElseThrow(() -> new PlayerNotFound(id));
    }

    @Transactional
    public List<Player> getPlayers() {
        return this.playerRepository.findAll(currentSeason);
    }

}
