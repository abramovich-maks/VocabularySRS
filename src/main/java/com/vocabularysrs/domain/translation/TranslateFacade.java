package com.vocabularysrs.domain.translation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TranslateFacade {

    private final TranslationService translationService;

    public TranslationResult getTranslate(String word) {
        String targetLang = "ru"; // todo method 'getCurrentUserLang' to CurrentUserProvider, where user registrations he chooses their language
        return translationService.translate(word, targetLang);
    }
}