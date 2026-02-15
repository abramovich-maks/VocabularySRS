package com.vocabularysrs.domain.irregularverbs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class IrregularVerbConfiguration {

    @Bean
    public IrregularVerbFacade irregularVerbFacade(IrregularVerbRepository repository) {
        return new IrregularVerbFacade(repository);
    }
}
