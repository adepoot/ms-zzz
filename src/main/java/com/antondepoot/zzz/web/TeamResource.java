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
                        stats.name(),
                        stats.position(),
                        stats.points(),
                        stats.gamesPlayed(),
                        stats.gamesWon(),
                        stats.gamesDrawn(),
                        stats.gamesLost(),
                        stats.goalsFor(),
                        stats.goalsAgainst(),
                        stats.goalsDifference(),
                        stats.pointsPerGame()
                )).toList();
    }

}
