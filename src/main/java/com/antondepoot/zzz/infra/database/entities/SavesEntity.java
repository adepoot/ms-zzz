package com.antondepoot.zzz.infra.database.entities;

import com.antondepoot.zzz.domain.Save;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "saves")
public class SavesEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity keeper;

    @Column(name = "count")
    private int count;

    public Save toSave() {
        return new Save(this.id, this.keeper.toPlayer(), this.count);
    }

}
