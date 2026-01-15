package com.vocabularysrs.domain.translation;

public interface TranslationAlternativeService {
    TranslationAlternatives getAlternatives(String word, String targetLang);

}