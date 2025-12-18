package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.UserAnswerRequestDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DailyTestFacadeTest {

    DictionaryUpdatePort dictionaryUpdatePort = new DictionaryUpdatePortTestImpl();
    LearningTaskReadPort learningTaskReadPort = new LearningTaskReadPortTestImpl();
    DailyTestFacade dailyTestFacade = new DailyTestConfiguration().dailyTestFacade(learningTaskReadPort, dictionaryUpdatePort);

    @Test
    void should_count_correct_and_incorrect_answers() {
        // given
        LocalDate today = LocalDate.now();
        List<UserAnswerRequestDto> userAnswerRequestDtos = List.of(
                new UserAnswerRequestDto(1L, "кот             "),
                new UserAnswerRequestDto(2L, "dog"),
                new UserAnswerRequestDto(3L, "SUN")
        );
        DailyTestRequestDto request = new DailyTestRequestDto(1L, today, userAnswerRequestDtos);
        // when
        DailyTestResponseDto dailyTestResponseDto = dailyTestFacade.processDailyTest(request);
        // then
        assertThat(dailyTestResponseDto.incorrect()).isEqualTo(1);
        assertThat(dailyTestResponseDto.correct()).isEqualTo(2);
        assertThat(dailyTestResponseDto.total()).isEqualTo(3);
    }
}
