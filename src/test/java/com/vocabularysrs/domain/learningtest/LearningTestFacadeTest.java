package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.learningtest.dto.DailyTestDto;
import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.dto.QuestionDto;
import com.vocabularysrs.domain.words.WordEntrySnapshot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class LearningTestFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );
    private final WordEntryReadPortTestImpl readPort = new WordEntryReadPortTestImpl();
    private final LearningTestRepositoryTestImpl repository = new LearningTestRepositoryTestImpl();

    private final LearningTestFacade facade = new LearningTestConfigurations().learningTestFacade(repository, readPort, mock(WordEntryUpdatePort.class), new TestCurrentUserProvider(), clock);

    @Test
    void should_return_no_words_when_user_has_no_words() {
        // given
        // when
        DailyTestDto dailyTets = facade.getDailyTets();
        // then
        assertThat(dailyTets.status()).isEqualTo(DailyTestStatus.NO_WORDS);
    }


    @Test
    void should_return_available_when_words_exist() {
        // given
        readPort.setWords(List.of(new WordEntrySnapshot(1L, 1L, "cat", "кот")));
        // when
        DailyTestDto result = facade.getDailyTets();
        // then
        assertThat(result.status()).isEqualTo(DailyTestStatus.AVAILABLE);
        assertThat(result.questions()).isNotEmpty();
    }

    @Test
    void should_return_completed_when_all_questions_answered() {
        // given
        readPort.setWords(List.of(new WordEntrySnapshot(1L, 1L, "cat", "кот")));
        readPort.setNearestDate(clock.today());
        DailyTestDto generated = facade.getDailyTets();
        for (QuestionDto q : generated.questions()) {
            facade.answerTheQuestion(q.id(), "qwe");
        }
        // when
        DailyTestDto result = facade.getDailyTets();
        // then
        assertThat(result.status()).isEqualTo(DailyTestStatus.COMPLETED);
    }

    @Test
    void should_return_result_test() {
        // given
        readPort.setWords(List.of(new WordEntrySnapshot(1L, 1L, "cat", "кот")));
        readPort.setNearestDate(clock.today());
        DailyTestDto generated = facade.getDailyTets();
        for (QuestionDto q : generated.questions()) {
            facade.answerTheQuestion(q.id(), "CAT");
        }
        // when
        DailyTestResponseDto responseDto = facade.showTestResults();
        // then
        assertAll(
                () -> assertThat(responseDto.correct()).isEqualTo(1),
                () -> assertThat(responseDto.incorrect()).isEqualTo(1),
                () -> assertThat(responseDto.answers()).hasSize(2)
        );
    }

    @Test
    void should_exception_when_user_not_has_result() {
        // given
        // when
        LearningTestNotFoundException exception = assertThrows(LearningTestNotFoundException.class, facade::showTestResults);
        // then
        assertThat(exception.getMessage()).isEqualTo("User 1 does not have a learning test for date 2025-01-01.");
    }

    @Test
    void should_exception_when_user_answered_for_not_exist_question() {
        // given
        readPort.setWords(List.of(new WordEntrySnapshot(1L, 1L, "cat", "кот")));
        readPort.setNearestDate(clock.today());
        facade.getDailyTets();
        long firstQuestionId = 1L;
        long secondQuestionId = 2L;
        long nonExistentQuestionId = 3L;
        facade.answerTheQuestion(firstQuestionId, "f");
        facade.answerTheQuestion(secondQuestionId, "s");

        DailyTestResponseDto results = facade.showTestResults();
        assertAll(
                () -> assertThat(results.correct()).isEqualTo(0),
                () -> assertThat(results.incorrect()).isEqualTo(2),
                () -> assertThat(results.answers())
                        .extracting(AnswerResultDto::questionId)
                        .containsExactlyInAnyOrder(1L, 2L),
                () -> assertThat(results.answers()).hasSize(2)
        );
        // when
        QuestionNotFoundException exception = assertThrows(QuestionNotFoundException.class, () -> {
            facade.answerTheQuestion(nonExistentQuestionId, "qwe");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo("User 1 does not have a question with id " + nonExistentQuestionId + ".");
    }
}