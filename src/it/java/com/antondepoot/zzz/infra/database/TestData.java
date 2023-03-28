package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.infra.database.entities.PlayerEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.sql.Date;
import java.time.Instant;
import java.util.Collections;
import java.util.UUID;

public class TestData {

    public static PlayerEntity aPlayerWithId(final UUID id) {
        return PlayerEntity.builder()
                .id(id)
                .firstName(RandomStringUtils.randomAlphabetic(5, 10))
                .lastName(RandomStringUtils.randomAlphabetic(5, 10))
                .nickname(RandomStringUtils.randomAlphabetic(5, 10))
                .birthday(Date.from(Instant.now()))
                .number(RandomUtils.nextInt())
                .createdAt(Instant.now())
                .goals(Collections.emptyList())
                .assists(Collections.emptyList())
                .saves(Collections.emptyList())
                .games(Collections.emptyList())
                .build();
    }

    public static PlayerEntity aPlayer() {
        return PlayerEntity.builder()
                .id(UUID.randomUUID())
                .firstName(RandomStringUtils.randomAlphabetic(5, 10))
                .lastName(RandomStringUtils.randomAlphabetic(5, 10))
                .nickname(RandomStringUtils.randomAlphabetic(5, 10))
                .birthday(Date.from(Instant.now()))
                .number(RandomUtils.nextInt())
                .createdAt(Instant.now())
                .goals(Collections.emptyList())
                .assists(Collections.emptyList())
                .saves(Collections.emptyList())
                .games(Collections.emptyList())
                .build();
    }

}
