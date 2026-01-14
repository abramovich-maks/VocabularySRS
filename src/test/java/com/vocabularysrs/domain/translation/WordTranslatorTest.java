package com.vocabularysrs.domain.translation;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordTranslatorTest {

    TranslationServiceTestImpl translationService = new TranslationServiceTestImpl();
    CurrentUserProvider userProvider = new TestCurrentUserProvider();
    private final WordTranslator wordTranslator = new TranslationFacadeConfigurations().translateFacade(translationService, userProvider);


    @Test
    void shouldTranslateWordToRussian() {
        // when
        TranslationResult result = wordTranslator.translate("cat");
        // then
        assertThat(result.translatedText()).isEqualTo("кот");
    }
}