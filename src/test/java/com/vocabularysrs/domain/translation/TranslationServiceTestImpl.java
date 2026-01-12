package com.vocabularysrs.domain.translation;

class TranslationServiceTestImpl implements TranslationService {

    @Override
    public TranslationResult translate(String word, String targetLang) {
        if (word.equals("dog") && targetLang.equals("ru")) {
            return new TranslationResult(word, "собака");
        }
        if (word.equals("cat") && targetLang.equals("ru")) {
            return new TranslationResult(word, "кот");
        }
        return new TranslationResult(word, "");
    }
}
