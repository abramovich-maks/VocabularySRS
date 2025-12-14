package com.vocabularysrs.domain.loginandregister;

import lombok.Builder;

@Builder
public record UserRegisterResponseDto(
        Long userId,
        String username,
        String surname,
        String email,
        String message
) {
}
