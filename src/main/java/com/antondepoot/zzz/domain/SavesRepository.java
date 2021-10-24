package com.antondepoot.zzz.domain;

import com.antondepoot.zzz.domain.entities.Saves;
import com.antondepoot.zzz.domain.entities.Season;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SavesRepository {

    List<Saves> findAllSavesForPlayer(final UUID id, final Season season);

}
