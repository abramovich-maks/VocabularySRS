package com.vocabularysrs.domain.loginandregister.dto;

public record UserLoginRequestDto(
        String email,
        String password
) {
}
