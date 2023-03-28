package com.antondepoot.zzz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SavesRepository {

    List<Save> findAllSavesForPlayer(final UUID id, final Season season);

}
