package com.vocabularysrs.domain.translation;

import lombok.Builder;

@Builder
public record TranslationResult(
        String word,
        String translatedText
) {
}