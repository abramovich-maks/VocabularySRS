package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.infrastructure.security.StubCurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordEntryConfiguration {

    @Bean
    DictionaryFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, currentUserProvider);
        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordRetriever);
        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
        return new DictionaryFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater);
    }

    @Bean
    CurrentUserProvider currentUserProvider() {
        return new StubCurrentUserProvider();
    }
}
