package com.vocabularysrs.domain.translation;

import lombok.Builder;

@Builder
public record TranslationResult(
        String word,
        String translatedText
) {
    public boolean isSuccessful() {
        return translatedText != null && !translatedText.isBlank();
    }
}