package com.vocabularysrs.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserRegisterRequestDto(
        String username,
        String surname,
        String email,
        String password
) {
}