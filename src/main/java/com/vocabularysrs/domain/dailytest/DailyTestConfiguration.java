package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class DailyTestConfiguration {

    @Bean
    DailyTestFacade dailyTestFacade(LearningTaskReadPort learningTaskReadPort, LearningTaskGeneratorFacade learningTaskGeneratorFacade, DictionaryUpdatePort dictionaryUpdatePort, CurrentUserProvider currentUserProvider, Clock clock) {
        DailyTestChecker dailyTestChecker = new DailyTestChecker(learningTaskReadPort);
        DailyTestRetriever dailyTestRetriever = new DailyTestRetriever(learningTaskReadPort);
        return new DailyTestFacade(dailyTestChecker, currentUserProvider, dictionaryUpdatePort, dailyTestRetriever, learningTaskGeneratorFacade,learningTaskReadPort, clock);
    }
}
