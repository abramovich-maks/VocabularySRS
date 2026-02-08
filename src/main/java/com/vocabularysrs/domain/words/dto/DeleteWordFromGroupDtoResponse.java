package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record DeleteWordFromGroupDtoResponse(
        String message
) {
}
