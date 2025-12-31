//package com.vocabularysrs.infrastructure.learningtaskgenerator.scheduler;
//
//import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.Clock;
//import java.time.LocalDate;
//
//@AllArgsConstructor
//@Log4j2
//@Component
//class LearningTaskScheduler {
//
//    private final LearningTaskGeneratorFacade learningTaskGeneratorFacade;
//    private final Clock clock;
//
//    @Scheduled(cron = "${vocabulary.learning-task-generator.scheduler}")
//    public void createDailyReviewTask() {
//        try {
//            learningTaskGeneratorFacade.generateTasks(LocalDate.now(clock));
//        } catch (IllegalStateException e) {
//            log.info(e.getMessage());
//        }
//    }
//}
