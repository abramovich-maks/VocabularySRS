package com.vocabularysrs.infrastructure.api;

public record ApiErrorResponse(
        String code,
        String message
) {
}
