package com.antondepoot.zzz.rest;

import com.antondepoot.zzz.rest.responses.PlayerStatsResponse;
import com.antondepoot.zzz.services.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stats")
public class StatsResource {

    private final PlayerService playerService;

    public StatsResource(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players")
    List<PlayerStatsResponse> getPlayerStatistics() {
        return this.playerService.getPlayers().stream()
                .map(PlayerStatsResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }

}
