package com.vocabularysrs.domain.loginandregister;

import lombok.Builder;

@Builder
public record UserDtoResponse(
        String email,
        String password
) {
}
