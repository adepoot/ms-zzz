package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.domain.exceptions.PlayerNotFound;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player getPlayerInfo(final UUID id) {
        return this.playerRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new PlayerNotFound(id));
    }

}
