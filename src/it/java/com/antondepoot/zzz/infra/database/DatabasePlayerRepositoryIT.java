package com.antondepoot.zzz.infra.database;

import com.antondepoot.zzz.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DatabaseIntegrationTest
class DatabasePlayerRepositoryIT {

    @Autowired
    DatabasePlayerRepository repository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void finds_player_by_id() {
        var id = UUID.randomUUID();
        Player expected = persist(TestData.aPlayerWithId(id)).toPlayer();

        Optional<Player> response = this.repository.findById(id);

        assertThat(response).isNotEmpty();
        assertThat(response.get()).isEqualTo(expected);
    }

    @Test
    void finds_nothing_for_unknown_id() {
        persist(TestData.aPlayer());

        Optional<Player> response = this.repository.findById(UUID.randomUUID());

        assertThat(response).isEmpty();
    }

    private <E> E persist(E entity) {
        return this.testEntityManager.persistAndFlush(entity);
    }
}
