package com.antondepoot.zzz.rest.responses;

import com.antondepoot.zzz.domain.entities.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
@ApiModel("Player")
public final class PlayerResponse {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birthday")
    private ZonedDateTime birthday;

    public static PlayerResponse from(final Player player) {
        return builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .birthday(player.getBirthday())
                .build();
    }
}
