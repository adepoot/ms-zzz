package com.antondepoot.zzz.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "goals")
public class Goal {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "scorer_id")
    private Player scorer;

    @ManyToOne
    @JoinColumn(name = "assister_id")
    private Player assister;

    @Column(name = "penalty")
    private boolean penalty;

}
