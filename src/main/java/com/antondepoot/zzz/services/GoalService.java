package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.GoalRepository;
import com.antondepoot.zzz.domain.entities.Goal;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class GoalService {

    private static final Season CURRENT_SEASON = Season.SEASON_2021_2022;

    private final GoalRepository goalRepository;

    public GoalService(final GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Transactional
    public List<Goal> getGoalsFor(final UUID playerId) {
        return this.goalRepository.findAllGoalsForPlayer(playerId, CURRENT_SEASON);
    }

    @Transactional
    public List<Goal> getAssistsFor(final UUID playerId) {
        return this.goalRepository.findAllAssistsForPlayer(playerId, CURRENT_SEASON);
    }

}
