package com.antondepoot.zzz.domain.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nickname")
    private String nickName;

    @Temporal(TemporalType.DATE)
    private ZonedDateTime birthday;

    @Email
    private String email;

    @Column(name = "goal_id")
    @ElementCollection
    @CollectionTable(name = "goals", joinColumns = @JoinColumn(name = "player_id"))
    private Collection<Goal> goals;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;
}
