package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandingRepo {

    List<TeamStats> getCurrentStandings();

}
