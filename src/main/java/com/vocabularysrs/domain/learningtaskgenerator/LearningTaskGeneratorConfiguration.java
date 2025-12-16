package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.dailywordsselector.DailyWordReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LearningTaskGeneratorConfiguration {

    @Bean
    LearningTaskGeneratorFacade learningTaskGeneratorFacade(DailyWordReadPort dailyWordReadPort, LearningTaskRepository learningTaskRepository) {
        LearningTaskAdder learningTaskAdder = new LearningTaskAdder(dailyWordReadPort, learningTaskRepository);
        return new LearningTaskGeneratorFacade(learningTaskAdder);
    }
}
