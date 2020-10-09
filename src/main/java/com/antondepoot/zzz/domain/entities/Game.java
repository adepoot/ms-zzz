package com.antondepoot.zzz.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "games")
public class Game {

    @Id
    private UUID id;

    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @Column(name = "home_score")
    private int homeScore;

    @Column(name = "away_score")
    private int awayScore;

    @ManyToMany
    @JoinTable(
            name = "game_player",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Collection<Player> players;
}
