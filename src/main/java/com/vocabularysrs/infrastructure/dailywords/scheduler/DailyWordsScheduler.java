package com.vocabularysrs.infrastructure.dailywords.scheduler;

import com.vocabularysrs.domain.dailywordsselector.DailyWordsSelectorFacade;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Log4j2
@Component
class DailyWordsScheduler {
    private final DailyWordsSelectorFacade dailyWordsSelectorFacade;

    @Scheduled(cron = "${vocabulary.daily-words.scheduler}")
    public void retrieveWords() {
        try {
            dailyWordsSelectorFacade.retrieveWordsByDate();
        } catch (IllegalStateException e) {
            log.info(e.getMessage());
        }
    }
}