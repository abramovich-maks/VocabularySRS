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
                                                 Clock clock,
                                                 UserReadPort userReadPort,
                                                 LearningTestHistoryRepository learningTestHistoryRepository) {
        LearningTestGenerator learningTestGenerator = new LearningTestGenerator(learningTaskRepository, wordEntryReadPort, userReadPort);
        DailyTestRetriever retriever = new DailyTestRetriever(learningTestGenerator, user, wordEntryReadPort, learningTaskRepository, userReadPort, clock);
        DailyTestResultRetriever resultRetriever = new DailyTestResultRetriever(learningTaskRepository, wordEntryUpdatePort, user, userReadPort, clock, learningTestHistoryRepository);
        DailyTestAnswerAccepter answerAccepter = new DailyTestAnswerAccepter(user, learningTaskRepository, userReadPort);
        return new LearningTestFacade(retriever, resultRetriever, answerAccepter);
    }
}
