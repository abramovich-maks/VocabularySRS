package com.vocabularysrs.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserLoginResponseDto(
        String message
) {
}
