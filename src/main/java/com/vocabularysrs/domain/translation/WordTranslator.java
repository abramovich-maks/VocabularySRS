package com.vocabularysrs.domain.translation;

import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordTranslator {

    private final TranslationService translationService;
    private final CurrentUserProvider userProvider;

    public TranslationResult translate(String word) {
        Language language = userProvider.getCurrentUserLanguage();
        String targetLang = language.getLanguage();
        return translationService.translate(word, targetLang);
    }
}