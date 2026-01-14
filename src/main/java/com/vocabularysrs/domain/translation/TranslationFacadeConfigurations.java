package com.vocabularysrs.domain.translation;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranslationFacadeConfigurations {

    @Bean
    WordTranslator translateFacade(TranslationService translationService, CurrentUserProvider userProvider) {
        return new WordTranslator(translationService, userProvider);
    }
}