package com.vocabularysrs.domain.words;


import com.vocabularysrs.domain.globalwords.GlobalWordFacade;
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
    WordsFacade dictionaryFacade(WordEntryRepository wordRepository, CurrentUserProvider currentUserProvider, Clock clock, WordDetailsDeleter wordDetailsDeleter, TranslationService translationService, WordDetailsFetchable wordFetchable, WordsGroupRepository groupRepository, WordGroupLinkRepository linkRepository, final GlobalWordFacade globalWordFacade) {
        WordRetriever wordRetriever = new WordRetriever(wordRepository, currentUserProvider);
        WordTranslator wordTranslator = new WordTranslator(translationService, currentUserProvider);
        WordsGroupRetriever wordsGroupRetriever = new WordsGroupRetriever(groupRepository, linkRepository, currentUserProvider);
        GroupWordAssigner wordAssigner = new GroupWordAssigner(linkRepository, wordRepository, wordsGroupRetriever, currentUserProvider);
        WordAdder wordAdder = new WordAdder(wordRepository, wordRetriever, currentUserProvider, wordTranslator, wordFetchable, wordsGroupRetriever, wordAssigner, globalWordFacade, clock);
        WordDeleter wordDeleter = new WordDeleter(wordRepository, wordRetriever, wordDetailsDeleter, linkRepository);
        WordUpdater wordUpdater = new WordUpdater(wordRetriever);
        return new WordsFacade(wordAdder, wordDeleter, wordRetriever, wordUpdater, wordAssigner);
    }

    @Bean
    CurrentUserProvider currentUserProvider() {
        return new JwtCurrentUserProvider();
    }

    @Bean
    WordEntryUpdateAdapter dictionaryUpdateAdapter(WordEntryRepository wordEntryRepository, RepetitionIntervalCalculator calculator, Clock clock, CurrentUserProvider currentUserProvider) {
        WordRetriever wordRetriever = new WordRetriever(wordEntryRepository, currentUserProvider);
        return new WordEntryUpdateAdapter(wordEntryRepository, wordRetriever, calculator, clock);
    }

    @Bean
    WordsGroupFacade wordsGroupFacade(WordsGroupRepository groupRepository, CurrentUserProvider currentUserProvider, WordGroupLinkRepository linkRepository, WordEntryRepository wordRepository) {
        WordsGroupRetriever wordsGroupRetriever = new WordsGroupRetriever(groupRepository, linkRepository, currentUserProvider);
        WordsGroupAdder groupAdder = new WordsGroupAdder(wordsGroupRetriever, groupRepository, currentUserProvider);
        WordsGroupDeleter wordsGroupDeleter = new WordsGroupDeleter(groupRepository, wordsGroupRetriever, linkRepository);
        WordsGroupUpdater wordsGroupUpdater = new WordsGroupUpdater(wordsGroupRetriever);
        GroupWordAssigner wordAssigner = new GroupWordAssigner(linkRepository, wordRepository, wordsGroupRetriever, currentUserProvider);
        return new WordsGroupFacade(groupAdder, wordsGroupDeleter, wordsGroupRetriever, wordsGroupUpdater, wordAssigner);
    }
}
