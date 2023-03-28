package com.antondepoot.zzz.domain;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record Player(UUID id, String firstName, String lastName, String nickname, int number, Date birthday,
                     String email) {

}
