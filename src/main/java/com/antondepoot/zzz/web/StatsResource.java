package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.Game;
import com.antondepoot.zzz.domain.Save;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.services.StatisticsService;
import com.antondepoot.zzz.web.responses.PlayerResponse;
import com.antondepoot.zzz.web.responses.StatsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
                    final List<Game> games = this.statisticsService.getGamesFor(player.id());
                    final int goals = this.statisticsService.getGoalsFor(player.id()).size();
                    final int assists = this.statisticsService.getAssistsFor(player.id()).size();
                    final int saves = this.statisticsService.getSavesFor(player.id()).stream().mapToInt(Save::count).sum();
                    final Double averageGoalsAgainstPerGame = games.stream().mapToDouble(Game::awayScore).average().orElse(0d);

                    return new StatsResponse(PlayerResponse.from(player), games.size(), goals, assists, saves, averageGoalsAgainstPerGame);
                }).toList();
    }

}
