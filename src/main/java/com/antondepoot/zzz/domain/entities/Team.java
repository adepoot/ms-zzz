package com.antondepoot.zzz.domain.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "teams")
@Getter
public class Team {

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
    private Collection<Game> homeGames;

    @OneToMany(mappedBy = "awayTeam")
    private Collection<Game> awayGames;

}
