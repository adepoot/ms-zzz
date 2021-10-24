package com.antondepoot.zzz.web;

import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.web.responses.StatsResponse;
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
    List<StatsResponse> getPlayerStatistics() {
        return this.playerService.getPlayers().stream()
                .map(StatsResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }

}
