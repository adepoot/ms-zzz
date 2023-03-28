package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.Player;
import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.exceptions.PlayerNotFound;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.antondepoot.zzz.TestData.aPlayer;
import static com.antondepoot.zzz.TestData.aPlayerWithId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerServiceTest {
    private static final UUID ID = UUID.randomUUID();

    private final AppProperties appProperties = new AppProperties();
    private final PlayerRepository playerRepository = mock(PlayerRepository.class);
    private final PlayerService playerService = new PlayerService(appProperties, playerRepository);

    @Test
    void returns_player_when_found() {
        final Player expected = aPlayerWithId(ID);
        when(this.playerRepository.findById(ID)).thenReturn(
                Optional.of(expected)
        );

        final Player response = this.playerService.getPlayer(ID);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void throws_error_when_player_not_found() {
        when(this.playerRepository.findById(ID)).thenReturn(
                Optional.empty()
        );

        assertThrows(PlayerNotFound.class, () -> this.playerService.getPlayer(ID));
    }

    @Test
    void returns_all_players() {
        final List<Player> expected = Arrays.asList(aPlayer(), aPlayer(), aPlayer());
        when(this.playerRepository.findAll(any())).thenReturn(
                expected
        );

        final List<Player> response = this.playerService.getPlayers();

        assertThat(response).containsExactlyInAnyOrderElementsOf(expected);
    }

}
