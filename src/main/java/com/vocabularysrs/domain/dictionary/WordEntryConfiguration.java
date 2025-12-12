package com.vocabularysrs.domain.dictionary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordEntryConfiguration {

    @Bean
    DictionaryFacade dictionaryFacade(WordEntryRepository wordRepository) {
        WordAdder wordAdder = new WordAdder(wordRepository);
        return new DictionaryFacade(wordAdder);
    }
}
