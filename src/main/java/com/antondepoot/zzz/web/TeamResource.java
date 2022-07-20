package com.antondepoot.zzz.web;

import com.antondepoot.zzz.services.LzvCupService;
import com.antondepoot.zzz.web.responses.TeamStatsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/standings")
class TeamResource {

    private final LzvCupService lzvCupService;

    TeamResource(final LzvCupService lzvCupService) {
        this.lzvCupService = lzvCupService;
    }

    @GetMapping
    List<TeamStatsResponse> getCurrentStandings() {
        return this.lzvCupService.getCurrentStandings().stream()
                .map(stats -> new TeamStatsResponse(
                        stats.getName(),
                        stats.getPosition(),
                        stats.getPoints(),
                        stats.getMatchesPlayed(),
                        stats.getMatchesWon(),
                        stats.getMatchesDrawn(),
                        stats.getMatchesLost(),
                        stats.getGoalsFor(),
                        stats.getGoalsAgainst(),
                        stats.getGoalsDifference(),
                        stats.getPointsPerMatch()
                ))
                .collect(Collectors.toList());
    }

}
