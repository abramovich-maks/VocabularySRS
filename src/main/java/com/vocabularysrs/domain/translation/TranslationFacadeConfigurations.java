package com.vocabularysrs.domain.translation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TranslationFacadeConfigurations {

    @Bean
    WordTranslator translateFacade(TranslationService translationService) {
        return new WordTranslator(translationService);
    }
}