package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.entities.Goal;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.services.GoalService;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.web.responses.PlayerInfoResponse;
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

    PlayerResource(final PlayerService playerService, final GoalService goalService) {
        this.playerService = playerService;
        this.goalService = goalService;
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

    @GetMapping("/{id}/stats")
    StatsResponse getPlayerStats(@PathVariable("id") final UUID id) {
        return StatsResponse.from(this.playerService.getPlayer(id));
    }

    @GetMapping("/{id}/stats/goals")
    List<StatsDetailResponse> getPlayerGoalsDetail(@PathVariable("id") final UUID id) {
        List<Goal> goals = this.goalService.getGoalDetailsFor(id);

        List<StatsDetailResponse> response = new ArrayList<>();
        goals.stream()
                .collect(groupingBy(goal -> Optional.ofNullable(goal.getAssister())))
                .forEach((player, goalz) -> response.add(StatsDetailResponse.from(player, goalz)));

        return response;
    }

}
