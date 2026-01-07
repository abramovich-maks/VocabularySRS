package com.vocabularysrs.domain.words;


import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.worddetails.WordDetailsDeleter;
import com.vocabularysrs.infrastructure.security.JwtCurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class WordEntryConfiguration {

    @Bean
    WordsFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider, Clock clock, WordDetailsDeleter wordDetailsDeleter) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository, currentUserProvider);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, currentUserProvider, clock);
        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordRetriever, wordDetailsDeleter);
        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
        return new WordsFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater);
    }

    @Bean
    CurrentUserProvider currentUserProvider() {
        return new JwtCurrentUserProvider();
    }

    @Bean
    DictionaryUpdateAdapter dictionaryUpdateAdapter(WordEntryRepository wordEntryRepository, RepetitionIntervalCalculator calculator, Clock clock, CurrentUserProvider currentUserProvider) {
        WordRetriever wordRetriever = new WordRetriever(wordEntryRepository, currentUserProvider);
        return new DictionaryUpdateAdapter(wordEntryRepository, wordRetriever, calculator, clock);
    }
}
