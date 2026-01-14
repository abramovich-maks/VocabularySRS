package com.vocabularysrs.domain.translation;

import com.vocabularysrs.domain.loginandregister.UserLanguage;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordTranslator {

    private final TranslationService translationService;
    private final CurrentUserProvider userProvider;

    public TranslationResult translate(String word) {
        UserLanguage userLanguage = userProvider.getCurrentUserLanguage();
        String targetLang = userLanguage.getLanguage();
        return translationService.translate(word, targetLang);
    }
}