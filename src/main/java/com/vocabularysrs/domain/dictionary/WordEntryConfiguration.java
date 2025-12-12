package com.vocabularysrs.domain.dictionary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordEntryConfiguration {

    @Bean
    DictionaryFacade dictionaryFacade(WordEntryRepository wordRepository) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever);
        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordRetriever);
        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
        return new DictionaryFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater);
    }
}
