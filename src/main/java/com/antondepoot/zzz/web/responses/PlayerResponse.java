package com.antondepoot.zzz.web.responses;

import com.antondepoot.zzz.domain.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PlayerResponse {

    @JsonProperty("id")
    UUID id;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("nickname")
    String nickname;

    @JsonProperty("number")
    int number;

    public static PlayerResponse from(final Player player) {
        return builder()
                .id(player.id())
                .firstName(player.firstName())
                .lastName(player.lastName())
                .nickname(player.nickname())
                .number(player.number())
                .build();
    }
}
