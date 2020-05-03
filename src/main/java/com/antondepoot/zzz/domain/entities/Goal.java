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
    private Player scorer;

//    @ManyToOne
//    private Game game;

    @ManyToOne
    private Player assister;

    @Column(name = "penalty")
    private boolean penalty;
}
