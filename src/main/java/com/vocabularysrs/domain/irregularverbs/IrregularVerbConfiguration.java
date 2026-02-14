package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class IrregularVerbConfiguration {

    @Bean
    public IrregularVerbFacade irregularVerbFacade(IrregularVerbRepository repository, CurrentUserProvider currentUserProvider) {
        return new IrregularVerbFacade(repository, currentUserProvider);
    }
}
