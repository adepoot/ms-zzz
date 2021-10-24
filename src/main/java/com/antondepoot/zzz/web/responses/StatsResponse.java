package com.antondepoot.zzz.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
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

}
