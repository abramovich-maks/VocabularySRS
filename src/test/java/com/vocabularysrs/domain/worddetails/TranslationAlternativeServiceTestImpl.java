package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.translation.TranslationAlternativeService;
import com.vocabularysrs.domain.translation.TranslationAlternatives;

import java.util.List;

class TranslationAlternativeServiceTestImpl implements TranslationAlternativeService {

    @Override
    public TranslationAlternatives getAlternatives(String word, String targetLang) {
        return new TranslationAlternatives(
                List.of("мать", "мама")
        );
    }
}
