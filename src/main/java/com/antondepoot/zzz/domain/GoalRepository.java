package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoalRepository {

    List<Goal> findAllGoalsForPlayer(final UUID id, final Season season);

    List<Goal> findAllAssistsForPlayer(final UUID id, final Season season);

}
