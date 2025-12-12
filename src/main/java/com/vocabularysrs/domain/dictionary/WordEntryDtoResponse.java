package com.vocabularysrs.domain.dictionary;

import lombok.Builder;

@Builder
public record WordEntryDtoResponse(
        String word,
        String translate,
        String message
) {
}
