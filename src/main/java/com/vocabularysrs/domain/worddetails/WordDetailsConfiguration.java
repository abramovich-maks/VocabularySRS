package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordDetailsConfiguration {

    @Bean
    WordDetailsFacade detailsFacade(WordDetailsRepository repository, WordEntryReadPort wordEntryReadPort, WordDetailsFetchable fetchable, CurrentUserProvider currentUserProvider) {
        return new WordDetailsFacade(repository, wordEntryReadPort, fetchable, currentUserProvider);
    }
}