package com.vocabularysrs.domain.translation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TranslationFacadeConfigurations {

    @Bean
    TranslateFacade translateFacade(TranslationService translationService) {
        return new TranslateFacade(translationService);
    }
}