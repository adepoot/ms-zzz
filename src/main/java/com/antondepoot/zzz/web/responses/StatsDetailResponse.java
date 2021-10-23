package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.entities.Goal;
import com.antondepoot.zzz.domain.entities.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Value
@Builder
public class StatsDetailResponse {

    @JsonProperty("id")
    UUID id;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

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
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .amount(goals.size())
                .build();
    }

}
