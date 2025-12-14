package com.vocabularysrs.domain.loginandregister.dto;

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
