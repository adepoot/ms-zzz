package com.antondepoot.zzz.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "saves")
public class Saves {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player keeper;

    @Column(name = "count")
    private int count;

}
