package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.entities.Goal;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.services.GameService;
import com.antondepoot.zzz.services.GoalService;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.web.responses.PlayerResponse;
import com.antondepoot.zzz.web.responses.StatsDetailResponse;
import com.antondepoot.zzz.web.responses.StatsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/players")
class PlayerResource {

    private final PlayerService playerService;
    private final GoalService goalService;
    private final GameService gameService;

    PlayerResource(final PlayerService playerService, final GoalService goalService, final GameService gameService) {
        this.playerService = playerService;
        this.goalService = goalService;
        this.gameService = gameService;
    }

    @GetMapping
    List<PlayerResponse> getPlayers() {
        List<Player> players = this.playerService.getPlayers();
        return players.stream().map(PlayerResponse::from).collect(Collectors.toList());
    }

    @GetMapping("/{id}/info")
    PlayerResponse getPlayerInfo(@PathVariable("id") final UUID id) {
        return PlayerResponse.from(this.playerService.getPlayer(id));
    }

    @GetMapping("/{id}/stats")
    StatsResponse getPlayerStats(@PathVariable("id") final UUID id) {
        final Player player = this.playerService.getPlayer(id);
        final int games = this.gameService.getGamesFor(id).size();
        final int goals = this.goalService.getGoalsFor(id).size();
        final int assists = this.goalService.getAssistsFor(id).size();

        // TODO: get saves
        return new StatsResponse(PlayerResponse.from(player), games, goals, assists, 0);
    }

    @GetMapping("/{id}/stats/goals")
    List<StatsDetailResponse> getPlayerGoalsDetail(@PathVariable("id") final UUID id) {
        List<Goal> goals = this.goalService.getGoalsFor(id);

        List<StatsDetailResponse> response = new ArrayList<>();
        goals.stream()
                .collect(groupingBy(goal -> Optional.ofNullable(goal.getAssister())))
                .forEach((player, goalz) -> response.add(StatsDetailResponse.from(player, goalz)));

        return response;
    }

}
