package com.vocabularysrs.infrastructure.api.validation;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ValidationErrorDto(
        List<String> message,
        HttpStatus status
) {
}
