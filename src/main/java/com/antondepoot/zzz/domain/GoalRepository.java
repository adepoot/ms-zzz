package com.antondepoot.zzz.domain;

import com.antondepoot.zzz.domain.entities.Goal;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoalRepository {

    List<Goal> findAllByPlayerId(final UUID id, final Season season);

}
