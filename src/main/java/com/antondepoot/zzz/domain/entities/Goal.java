package com.antondepoot.zzz.domain.entities;

import javax.persistence.Column;

public class Goal {

    @Column(name = "player_id")
    private Player scorer;

    @Column(name = "game_id")
    private Game game;

    @Column(name = "assist_id")
    private Player assister;

    private boolean penalty;
}
