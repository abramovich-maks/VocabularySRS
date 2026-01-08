package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskResultPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class DailyTestConfiguration {

    @Bean
    DailyTestFacade dailyTestFacade(LearningTaskReadPort learningTaskReadPort, LearningTaskGeneratorFacade learningTaskGeneratorFacade, CurrentUserProvider currentUserProvider, Clock clock, LearningTaskWritePort learningTaskWritePort, DictionaryUpdatePort dictionaryUpdatePort, LearningTaskResultPort learningTaskResultPort) {
        DailyTestRetriever dailyTestRetriever = new DailyTestRetriever(learningTaskReadPort, learningTaskGeneratorFacade, currentUserProvider, clock);
        DailyTestAnswerAccepter dailyTestAnswerAccepter = new DailyTestAnswerAccepter(learningTaskWritePort, currentUserProvider);
        DailyTestResultRetriever dailyTestResultRetriever = new DailyTestResultRetriever(learningTaskResultPort, dictionaryUpdatePort, currentUserProvider, clock);
        return new DailyTestFacade(dailyTestRetriever, dailyTestAnswerAccepter, dailyTestResultRetriever);
    }
}
