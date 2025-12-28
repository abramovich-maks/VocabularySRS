package com.vocabularysrs.domain.dailywordsselector;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class DailyWordsSelectorConfiguration {

    @Bean
    DailyWordsSelectorFacade dailyWordsSelector(WordEntryReadPort wordEntryReadPort, DailyWordRepository dailyWordRepository, Clock clock) {
        return new DailyWordsSelectorFacade(wordEntryReadPort, dailyWordRepository, clock);
    }

}
