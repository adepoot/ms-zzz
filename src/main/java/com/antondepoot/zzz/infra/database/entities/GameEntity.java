package com.antondepoot.zzz.infra.database.entities;

import com.antondepoot.zzz.domain.Game;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "games")
public class GameEntity {

    @Id
    private UUID id;

    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;

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
    private Collection<PlayerEntity> players;

    public Game toBasicGame() {
        return Game.builder()
                .id(this.id)
                .date(this.date)
                .homeTeam(this.homeTeam.toTeam())
                .awayTeam(this.awayTeam.toTeam())
                .homeScore(this.homeScore)
                .awayScore(this.awayScore)
                .build();
    }
}
