package com.vocabularysrs.domain.words;

class WordNormalizer {

    static String normalizeWord(String word) {
        return word.trim().toLowerCase();
    }

    static String normalizeTranslate(String translate) {
        return translate.trim();
    }
}
