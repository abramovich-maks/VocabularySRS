package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import lombok.Builder;

@Builder
public record JwtResponseDto(String token) {
}