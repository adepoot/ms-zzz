package com.antondepoot.zzz.infra.database.entities;


import com.antondepoot.zzz.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "players")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "number")
    private int number;

    @Column(name = "birthday", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Email
    private String email;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "scorer")
    private Collection<GoalEntity> goals;

    @OneToMany(mappedBy = "assister")
    private Collection<GoalEntity> assists;

    @OneToMany(mappedBy = "keeper")
    private Collection<SavesEntity> saves;

    @ManyToMany(mappedBy = "players")
    private Collection<GameEntity> games;

    public Player toPlayer() {
        return Player.builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .nickname(this.nickname)
                .number(this.number)
                .birthday(this.birthday)
                .email(this.email)
                .build();
    }

}
