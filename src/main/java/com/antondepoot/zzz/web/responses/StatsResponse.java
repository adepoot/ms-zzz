package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.domain.entities.Saves;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StatsResponse {

    @JsonProperty("player")
    PlayerResponse player;

    @JsonProperty("selections")
    int selections;

    @JsonProperty("goals")
    int goals;

    @JsonProperty("assists")
    int assists;

    @JsonProperty("saves")
    int saves;

    public static StatsResponse from(final Player player) {
        return builder()
                .player(PlayerResponse.from(player))
                .selections(player.getGames().size())
                .goals(player.getGoals().size())
                .assists(player.getAssists().size())
                .saves(player.getSaves().stream().mapToInt(Saves::getCount).sum())
                .build();
    }
}
