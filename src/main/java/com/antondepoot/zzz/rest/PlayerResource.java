package com.antondepoot.zzz.rest;

import com.antondepoot.zzz.rest.responses.PlayerResponse;
import com.antondepoot.zzz.services.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/player")
class PlayerResource {

    private final PlayerService playerService;

    PlayerResource(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("info/{id}")
    PlayerResponse getPlayerInfo(@PathVariable("id") final UUID id) {
        return PlayerResponse.from(this.playerService.getPlayer(id));
    }

}
