package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.StandingRepo;
import com.antondepoot.zzz.domain.TeamStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveStandings {

    private final StandingRepo standingRepo;

    public RetrieveStandings(final StandingRepo standingRepo) {
        this.standingRepo = standingRepo;
    }

    public List<TeamStats> getCurrent() {
        return this.standingRepo.getCurrentStandings();
    }

}
