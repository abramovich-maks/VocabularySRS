package com.vocabularysrs.domain.words;


import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.translation.TranslationService;
import com.vocabularysrs.domain.translation.WordTranslator;
import com.vocabularysrs.domain.worddetails.WordDetailsDeleter;
import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
import com.vocabularysrs.infrastructure.security.JwtCurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class WordEntryConfiguration {

    @Bean
    WordsFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider, Clock clock, WordDetailsDeleter wordDetailsDeleter, TranslationService translationService, WordDetailsFetchable wordFetchable) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository, currentUserProvider);
        WordTranslator wordTranslator = new WordTranslator(translationService, currentUserProvider);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, currentUserProvider, wordTranslator, wordFetchable, clock);
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

    @Bean
    WordsGroupFacade wordsGroupFacade(WordsGroupRepository groupRepository, CurrentUserProvider currentUserProvider, WordEntryRepository wordEntryRepository) {
        WordsGroupRetriever wordsGroupRetriever = new WordsGroupRetriever(groupRepository, currentUserProvider);
        WordsGroupAdder groupAdder = new WordsGroupAdder(wordsGroupRetriever, groupRepository, currentUserProvider);
        WordsGroupDeleter wordsGroupDeleter = new WordsGroupDeleter(groupRepository, wordsGroupRetriever, wordEntryRepository, currentUserProvider);
        return new WordsGroupFacade(groupAdder, wordsGroupDeleter, wordsGroupRetriever);
    }
}
