package com.antondepoot.zzz.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFound extends RuntimeException {

    public PlayerNotFound(UUID id) {
        super(String.format("Player with id '%s' not found.", id));
    }
}
