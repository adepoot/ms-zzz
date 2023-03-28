package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.Goal;
import com.antondepoot.zzz.domain.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Optional;

@Value
@Builder
public class StatsDetailResponse {

    @JsonProperty("player")
    PlayerResponse player;

    @JsonProperty("amount")
    int amount;

    public static StatsDetailResponse from(final Optional<Player> optionalPlayer, final List<Goal> goals) {
        if (optionalPlayer.isEmpty()) {
            return StatsDetailResponse.builder()
                    .amount(goals.size())
                    .build();
        }

        return StatsDetailResponse.from(optionalPlayer.get(), goals);
    }

    private static StatsDetailResponse from(final Player player, final List<Goal> goals) {
        return StatsDetailResponse.builder()
                .player(PlayerResponse.from(player))
                .amount(goals.size())
                .build();
    }

}
