package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LearningTaskGeneratorConfiguration {

    @Bean
    public LearningTaskGeneratorFacade learningTaskGeneratorFacade(LearningTaskRepository learningTaskRepository, WordEntryReadPort wordEntryReadPort) {
        LearningTaskAdder learningTaskAdder = new LearningTaskAdder(learningTaskRepository, wordEntryReadPort);
        return new LearningTaskGeneratorFacade(learningTaskAdder);
    }
}
