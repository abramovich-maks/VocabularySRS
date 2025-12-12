package com.vocabularysrs.infrastructure.dictionary;

import lombok.Builder;

@Builder
public record DeletedWordEntryControllerDtoResponse(
        String message
) {
}
