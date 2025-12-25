package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.infrastructure.security.JwtCurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordEntryConfiguration {

    @Bean
    DictionaryFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider, AdjustableClock clock) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, currentUserProvider, clock);
        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordRetriever);
        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
        return new DictionaryFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater);
    }

    @Bean
    JwtCurrentUserProvider currentUserProvider() {
        return new JwtCurrentUserProvider();
    }

    @Bean
    DictionaryUpdateAdapter dictionaryUpdateAdapter(WordEntryRepository wordEntryRepository, RepetitionIntervalCalculator calculator, AdjustableClock clock) {
        WordRetriever wordRetriever = new WordRetriever(wordEntryRepository);
        return new DictionaryUpdateAdapter(wordEntryRepository, wordRetriever, calculator, clock);
    }
}
