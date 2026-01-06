//package com.vocabularysrs.domain.words;
//
//import com.vocabularysrs.domain.dictionary.WordDeleter;
//import com.vocabularysrs.domain.dictionary.WordDetailsEnricher;
//import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
//import com.vocabularysrs.domain.dictionary.WordDetailsReader;
//import com.vocabularysrs.domain.dictionary.WordDetailsRepository;
//import com.vocabularysrs.domain.security.CurrentUserProvider;
//import com.vocabularysrs.infrastructure.security.JwtCurrentUserProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.Clock;
//
//@Configuration
//class WordEntryConfiguration {
//
//    @Bean
//    DictionaryFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider, Clock clock, WordDetailsRepository wordDetailsRepository, WordDetailsFetchable wordDetailsFetchable) {
//        WordRetriever wordRetriever = new WordRetriever(wordRepository, currentUserProvider);
//        WordDetailsEnricher wordDetailsEnricher = new WordDetailsEnricher(wordDetailsFetchable, wordDetailsRepository, wordRetriever);
//        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, wordDetailsEnricher, currentUserProvider, clock);
//        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordDetailsRepository, wordRetriever);
//        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
//        WordDetailsReader wordDetailsReader = new WordDetailsReader(wordDetailsRepository, currentUserProvider);
//        return new DictionaryFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater, wordDetailsReader);
//    }
//
//    @Bean
//    CurrentUserProvider currentUserProvider() {
//        return new JwtCurrentUserProvider();
//    }
//
//    @Bean
//    DictionaryUpdateAdapter dictionaryUpdateAdapter(WordEntryRepository wordEntryRepository, RepetitionIntervalCalculator calculator, Clock clock, CurrentUserProvider currentUserProvider) {
//        WordRetriever wordRetriever = new WordRetriever(wordEntryRepository, currentUserProvider);
//        return new DictionaryUpdateAdapter(wordEntryRepository, wordRetriever, calculator, clock);
//    }
//}
