package com.antondepoot.zzz.infra.database.entities;

import com.antondepoot.zzz.domain.Team;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "teams")
@Getter
public class TeamEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "address_zipcode")),
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number"))
    })
    private Address address;
    
    @OneToMany(mappedBy = "homeTeam")
    private Collection<GameEntity> homeGames;

    @OneToMany(mappedBy = "awayTeam")
    private Collection<GameEntity> awayGames;

    public Team toTeam() {
        return new Team(this.id, this.name);
    }

}
