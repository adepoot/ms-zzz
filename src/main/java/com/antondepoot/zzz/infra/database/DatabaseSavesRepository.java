package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.Save;
import com.antondepoot.zzz.domain.SavesRepository;
import com.antondepoot.zzz.domain.Season;
import com.antondepoot.zzz.infra.database.entities.SavesEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class DatabaseSavesRepository implements SavesRepository {

    private static final Sort SORT = Sort.by(Sort.Direction.ASC, "game.date");

    private final SavesJpaRepository repository;

    public DatabaseSavesRepository(final SavesJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Save> findAllSavesForPlayer(UUID id, Season season) {
        return this.repository.findSavesByKeeper_IdAndGame_Date_AfterAndGame_Date_Before(
                        id, season.getStart(), season.getEnd(), SORT)
                .stream()
                .map(SavesEntity::toSave)
                .toList();
    }

}
