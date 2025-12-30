package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record DeletedWordEntryControllerDtoResponse(
        String message
) {
}
