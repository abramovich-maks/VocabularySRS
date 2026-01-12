package com.vocabularysrs.domain.translation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordTranslatorTest {

    TranslationServiceTestImpl translationService = new TranslationServiceTestImpl();
    private final WordTranslator wordTranslator = new TranslationFacadeConfigurations().translateFacade(translationService);


    @Test
    void shouldTranslateWordToRussian() {
        // when
        TranslationResult result = wordTranslator.translate("cat");
        // then
        assertThat(result.translatedText()).isEqualTo("кот");
    }
}