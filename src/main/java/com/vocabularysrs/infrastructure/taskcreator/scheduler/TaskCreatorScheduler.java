package com.vocabularysrs.infrastructure.taskcreator.scheduler;

import com.vocabularysrs.domain.dailywordsselector.DailyWordsSelectorFacade;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Log4j2
@Component
class TaskCreatorScheduler {
    private final DailyWordsSelectorFacade dailyWordsSelectorFacade;

    @Scheduled(cron = "${vocabulary.task-creator.scheduler}")
    public void createDailyReviewTask() {
        try {
            dailyWordsSelectorFacade.retrieveWordsByDate();
        } catch (IllegalStateException e) {
            log.info(e.getMessage());
        }
    }
}