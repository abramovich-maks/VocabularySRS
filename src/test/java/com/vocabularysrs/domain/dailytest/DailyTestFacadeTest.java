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

    DictionaryUpdatePort dictionaryUpdatePort = new DictionaryUpdatePortTestImpl();
    LearningTaskReadPort learningTaskReadPort = new LearningTaskReadPortTestImpl();
    CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
    WordEntryReadPort wordEntryReadPort;
    LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordRepository, wordEntryReadPort);
    DailyTestFacade dailyTestFacade = new DailyTestConfiguration().dailyTestFacade(learningTaskReadPort, learningTaskGeneratorFacade, dictionaryUpdatePort, currentUserProvider, clock);

    @Test
    void should_count_correct_and_incorrect_answers() {
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
    }
}
