package com.vocabularysrs.domain.translation;

public interface TranslationService {
    TranslationResult translate(String word, String targetLang);
}
