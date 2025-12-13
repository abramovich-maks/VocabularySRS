package com.vocabularysrs.domain.taskcreator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskCreatorConfiguration {

    @Bean
    TaskCreatorFacade taskCreatorFacade(WordEntryReadPort wordEntryReadPort, ReviewTaskRepository reviewTaskRepository) {
        return new TaskCreatorFacade(wordEntryReadPort, reviewTaskRepository);
    }

}
