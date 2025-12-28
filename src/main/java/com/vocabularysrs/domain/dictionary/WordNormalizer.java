package com.vocabularysrs.domain.dictionary;

class WordNormalizer {

    static String normalizeWord(String word) {
        return word.trim().toLowerCase();
    }

    static String normalizeTranslate(String translate) {
        return translate.trim();
    }
}
