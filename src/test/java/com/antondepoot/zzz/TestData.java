package com.antondepoot.zzz;

import com.antondepoot.zzz.domain.entities.Player;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public final class TestData {

    public static Player aPlayerWithId(final UUID id) {
        return Player.builder()
                .id(id)
                .firstName(RandomStringUtils.randomAlphabetic(5, 10))
                .lastName(RandomStringUtils.randomAlphabetic(5, 10))
                .nickname(RandomStringUtils.randomAlphabetic(5, 10))
                .birthday(Date.from(Instant.now()))
                .number(RandomUtils.nextInt())
                .build();
    }

    public static Player aPlayer() {
        return Player.builder()
                .id(UUID.randomUUID())
                .firstName(RandomStringUtils.randomAlphabetic(5, 10))
                .lastName(RandomStringUtils.randomAlphabetic(5, 10))
                .nickname(RandomStringUtils.randomAlphabetic(5, 10))
                .birthday(Date.from(Instant.now()))
                .number(RandomUtils.nextInt())
                .build();
    }
}
