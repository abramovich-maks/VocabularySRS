package com.vocabularysrs.infrastructure.learningtaskgenerator.scheduler;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Log4j2
@Component
class LearningTaskScheduler {

    private final LearningTaskGeneratorFacade learningTaskGeneratorFacade;

    @Scheduled(cron = "${vocabulary.learning-task-generator.scheduler}")
    public void createDailyReviewTask() {
        try {
            learningTaskGeneratorFacade.generateTasks();
        } catch (IllegalStateException e) {
            log.info(e.getMessage());
        }
    }
}
