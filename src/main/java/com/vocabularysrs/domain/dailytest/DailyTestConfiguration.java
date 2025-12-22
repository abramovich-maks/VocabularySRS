package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DailyTestConfiguration {

    @Bean
    DailyTestFacade dailyTestFacade(LearningTaskReadPort learningTaskReadPort, DictionaryUpdatePort dictionaryUpdatePort, CurrentUserProvider currentUserProvider, AdjustableClock clock) {
        DailyTestChecker dailyTestChecker = new DailyTestChecker(learningTaskReadPort);
        DailyTestRetriever dailyTestRetriever = new DailyTestRetriever(learningTaskReadPort);
        return new DailyTestFacade(dailyTestChecker, currentUserProvider, dictionaryUpdatePort, dailyTestRetriever, clock);
    }
}
