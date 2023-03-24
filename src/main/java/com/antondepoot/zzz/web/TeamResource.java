package com.antondepoot.zzz.web;

import com.antondepoot.zzz.services.RetrieveStandings;
import com.antondepoot.zzz.web.responses.TeamStatsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standings")
class TeamResource {

    private final RetrieveStandings retrieveStandings;

    TeamResource(final RetrieveStandings retrieveStandings) {
        this.retrieveStandings = retrieveStandings;
    }

    @GetMapping
    List<TeamStatsResponse> getCurrentStandings() {
        return this.retrieveStandings.getCurrent().stream()
                .map(stats -> new TeamStatsResponse(
                        stats.getName(),
                        stats.getPosition(),
                        stats.getPoints(),
                        stats.getGamesPlayed(),
                        stats.getGamesWon(),
                        stats.getGamesDrawn(),
                        stats.getGamesLost(),
                        stats.getGoalsFor(),
                        stats.getGoalsAgainst(),
                        stats.getGoalsDifference(),
                        stats.getPointsPerGame()
                )).toList();
    }

}
