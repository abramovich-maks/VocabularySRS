package com.vocabularysrs.domain.loginandregister;

import lombok.Builder;

@Builder
public record UserRegisterRequestDto(
        String username,
        String surname,
        String email,
        String password
) {
}