package com.antondepoot.zzz.infra.database.entities;

import com.antondepoot.zzz.domain.Goal;
import lombok.Data;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;

@Data
@Entity
@Table(name = "goals")
public class GoalEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "scorer_id")
    private PlayerEntity scorer;

    @ManyToOne
    @JoinColumn(name = "assister_id")
    private PlayerEntity assister;

    @Column(name = "penalty")
    private Boolean penalty;

    public Goal toGoal() {
        return Goal.builder()
                .id(this.id)
                .scorer(this.scorer.toPlayer())
                .assister(isNull(this.assister) ? Optional.empty() : Optional.of(this.assister.toPlayer()))
                .penalty(isNull(this.penalty) ? false : this.penalty)
                .build();
    }

}
