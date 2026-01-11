package com.vocabularysrs.domain.translation;

import lombok.Builder;

import java.util.List;

@Builder
public record TranslationResult(
        String word,
        String translatedText,
        List<String> alternative
) {
    public boolean isSuccessful() {
        return translatedText != null && !translatedText.isBlank();
    }
}