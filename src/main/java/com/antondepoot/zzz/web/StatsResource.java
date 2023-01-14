package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.entities.Saves;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.services.StatisticsService;
import com.antondepoot.zzz.web.responses.PlayerResponse;
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
    private final StatisticsService statisticsService;

    public StatsResource(final PlayerService playerService, final StatisticsService statisticsService) {
        this.playerService = playerService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("players")
    List<StatsResponse> getPlayerStatistics() {
        return this.playerService.getPlayers().stream()
                .map(player -> {
                    final int games = this.statisticsService.getGamesFor(player.getId()).size();
                    final int goals = this.statisticsService.getGoalsFor(player.getId()).size();
                    final int assists = this.statisticsService.getAssistsFor(player.getId()).size();
                    final int saves = this.statisticsService.getSavesFor(player.getId()).stream().mapToInt(Saves::getCount).sum();

                    return new StatsResponse(PlayerResponse.from(player), games, goals, assists, saves);
                }).toList();
    }

}
