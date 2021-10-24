package com.antondepoot.zzz.web;

import com.antondepoot.zzz.services.GameService;
import com.antondepoot.zzz.services.GoalService;
import com.antondepoot.zzz.services.PlayerService;
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
    private final GoalService goalService;
    private final GameService gameService;

    public StatsResource(final PlayerService playerService, final GoalService goalService, final GameService gameService) {
        this.playerService = playerService;
        this.goalService = goalService;
        this.gameService = gameService;
    }

    @GetMapping("players")
    List<StatsResponse> getPlayerStatistics() {
        return this.playerService.getPlayers().stream()
                .map(player -> {
                    final int games = this.gameService.getGamesFor(player.getId()).size();
                    final int goals = this.goalService.getGoalsFor(player.getId()).size();
                    final int assists = this.goalService.getAssistsFor(player.getId()).size();

                    // TODO: get saves
                    return new StatsResponse(PlayerResponse.from(player), games, goals, assists, 0);
                })
                .collect(Collectors.toUnmodifiableList());
    }

}
