package com.antondepoot.zzz.domain.entities;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @Column(name = "birthday", columnDefinition = "DATE")
    private ZonedDateTime birthday;

    @Email
    private String email;

    @OneToMany(mappedBy = "scorer")
    private Collection<Goal> goals;

    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime createdAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;
}
