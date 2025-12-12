package com.vocabularysrs.infrastructure.dictionary.dto;

import lombok.Builder;

@Builder
public record DeletedWordEntryControllerDtoResponse(
        String message
) {
}
