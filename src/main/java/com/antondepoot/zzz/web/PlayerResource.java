package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.web.responses.PlayerInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
class PlayerResource {

    private final PlayerService playerService;

    PlayerResource(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    List<PlayerInfoResponse> getPlayers() {
        List<Player> players = this.playerService.getPlayers();
        return players.stream().map(PlayerInfoResponse::from).collect(Collectors.toList());
    }

    @GetMapping("/{id}/info")
    PlayerInfoResponse getPlayerInfo(@PathVariable("id") final UUID id) {
        return PlayerInfoResponse.from(this.playerService.getPlayer(id));
    }

}
