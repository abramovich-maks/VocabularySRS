package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class LearningTestConfigurations {

    @Bean
    public LearningTestFacade learningTestFacade(LearningTestRepository learningTaskRepository,
                                                 WordEntryReadPort wordEntryReadPort,
                                                 WordEntryUpdatePort wordEntryUpdatePort,
                                                 CurrentUserProvider user,
                                                 Clock clock) {
        LearningTestGenerator learningTestGenerator = new LearningTestGenerator(learningTaskRepository, wordEntryReadPort);
        DailyTestRetriever retriever = new DailyTestRetriever(learningTestGenerator, user, wordEntryReadPort, learningTaskRepository, clock);
        DailyTestResultRetriever resultRetriever = new DailyTestResultRetriever(learningTaskRepository, wordEntryUpdatePort, user, clock);
        DailyTestAnswerAccepter answerAccepter = new DailyTestAnswerAccepter(user, learningTaskRepository);
        return new LearningTestFacade(retriever, resultRetriever, answerAccepter);
    }
}
