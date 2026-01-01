package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.UserAnswerRequestDto;
import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.InMemoryLearningTaskRepositoryTestImpl;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorConfiguration;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;
import com.vocabularysrs.domain.learningtaskgenerator.WordEntryReadPortTestImpl;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DailyTestFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    DictionaryUpdatePortTestImpl dictionaryUpdatePort = new DictionaryUpdatePortTestImpl();
    LearningTaskReadPort readPort = new LearningTaskReadPortTestImpl();
    LearningTaskWritePort writePort = new LearningTaskWritePortTestImpl();
    CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
    WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
    LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordRepository, wordEntryReadPort);
    DailyTestFacade dailyTestFacade = new DailyTestConfiguration().dailyTestFacade(readPort, learningTaskGeneratorFacade, dictionaryUpdatePort, currentUserProvider, clock, writePort);

    @Test
    void should_process_daily_test_and_return_statistics() {
        // given
        List<UserAnswerRequestDto> userAnswerRequestDtos = List.of(
                new UserAnswerRequestDto(1L, "кот             "),
                new UserAnswerRequestDto(2L, "dog"),
                new UserAnswerRequestDto(3L, "SUN")
        );
        DailyTestRequestDto request = new DailyTestRequestDto(userAnswerRequestDtos);
        // when
        DailyTestResponseDto dailyTestResponseDto = dailyTestFacade.processDailyTest(request);
        // then
        assertThat(dailyTestResponseDto.incorrect()).isEqualTo(1);
        assertThat(dailyTestResponseDto.correct()).isEqualTo(2);
        assertThat(dailyTestResponseDto.total()).isEqualTo(3);

        assertThat(dictionaryUpdatePort.lastUpdate).isNotNull();
        assertThat(dictionaryUpdatePort.lastUpdate.correct()).isEqualTo(2);
    }
}
