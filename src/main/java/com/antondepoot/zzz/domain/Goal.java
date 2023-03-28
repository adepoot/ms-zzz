package com.antondepoot.zzz.domain;

import lombok.Builder;

import java.util.Optional;
import java.util.UUID;

@Builder
public record Goal(UUID id, Player scorer, Optional<Player> assister, boolean penalty) {

}
