package com.vocabularysrs.infrastructure.security.jwt.vocabulary.error;

import org.springframework.http.HttpStatus;

public record LoginErrorResponse(
        String message,
        HttpStatus status
) {
}
