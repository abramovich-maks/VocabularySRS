package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.translation.TranslationResult;
import com.vocabularysrs.domain.translation.TranslationService;

class InMemoryTranslationServiceTestImpl implements TranslationService {
    @Override
    public TranslationResult translate(final String word, final String targetLang) {
        if (word.equals("cat") && targetLang.equals("ru")) {
            return new TranslationResult(word, "кот");
        }

        if (word.equals("cat") && targetLang.equals("pl")) {
            return new TranslationResult(word, "kot");
        }
        return null;
    }
}