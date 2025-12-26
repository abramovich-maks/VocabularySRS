package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.PASSWORD_MAX_SIZE;
import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.PASSWORD_MIN_SIZE;


public record TokenRequestDto(
        @NotNull(message = "{email.not.null}")
        @NotEmpty(message = "{email.not.empty}")
        @Email(message = "{email.email}")
        String email,

        @NotNull(message = "{password.not.null}")
        @NotEmpty(message = "{password.not.empty}")
        String password
) {
}
