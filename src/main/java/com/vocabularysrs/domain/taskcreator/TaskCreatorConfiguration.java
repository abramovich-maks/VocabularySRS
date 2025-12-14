package com.vocabularysrs.domain.taskcreator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskCreatorConfiguration {

    @Bean
    TaskCreatorFacade taskCreatorFacade(WordEntryReadPort wordEntryReadPort, ReviewTaskRepository reviewTaskRepository, CurrentUserProvider currentUserProvider) {
        return new TaskCreatorFacade(wordEntryReadPort, reviewTaskRepository, currentUserProvider);
    }

}
