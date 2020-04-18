package com.antondepoot.zzz.domain.exceptions;

import java.util.UUID;

public class PlayerNotFound extends RuntimeException {

    public PlayerNotFound(UUID id) {
        super(String.format("Player with id '%s' not found.", id));
    }
}
