package com.vocabularysrs.domain.dailywordsselector;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DailyWordsSelectorConfiguration {

    @Bean
    DailyWordsSelectorFacade dailyWordsSelector(WordEntryReadPort wordEntryReadPort, DailyWordRepository dailyWordRepository, AdjustableClock clock) {
        return new DailyWordsSelectorFacade(wordEntryReadPort, dailyWordRepository,clock);
    }

}
