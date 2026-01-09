package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.InMemoryLearningTaskRepositoryTestImpl;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorConfiguration;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskResultPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;
import com.vocabularysrs.domain.learningtaskgenerator.WordEntryReadPortTestImpl;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

class DailyTestFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    DictionaryUpdatePortTestImpl dictionaryUpdatePort = new DictionaryUpdatePortTestImpl();
    LearningTaskResultPort learningTaskResultPort = new LearningTaskResultPortTestImpl();
    LearningTaskReadPort readPort = new LearningTaskReadPortTestImpl();
    LearningTaskWritePort writePort = new LearningTaskWritePortTestImpl();
    CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
    WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
    LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordRepository, wordEntryReadPort);
    DailyTestFacade dailyTestFacade = new DailyTestConfiguration().dailyTestFacade(readPort, learningTaskGeneratorFacade, currentUserProvider, clock, writePort, dictionaryUpdatePort, learningTaskResultPort);


    @Test
    public void should_answer_for_question() {
        // given
        dailyTestFacade.retrieveDailyTest();
        // when
        AnswerResultDto resultDto = dailyTestFacade.answerQuestion(1L, "cat");
        // then
        assertAll(
                () -> assertThat(resultDto.questionId()).isEqualTo(1),
                () -> assertThat(resultDto.wordEntryId()).isEqualTo(1),
                () -> assertThat(resultDto.userAnswer()).isEqualTo("cat"),
                () -> assertThat(resultDto.correctAnswer()).isEqualTo("cat"),
                () -> assertThat(resultDto.correct()).isTrue());
    }


    @Test
    void should_return_daily_test_result() {
        // when
        DailyTestResponseDto result = dailyTestFacade.resultTest();
        // then
        assertAll(
                () -> assertThat(result.userId()).isEqualTo(1L),
                () -> assertThat(result.total()).isEqualTo(3),
                () -> assertThat(result.correct()).isEqualTo(1),
                () -> assertThat(result.incorrect()).isEqualTo(2),
                () -> assertThat(result.answers()).hasSize(3)
        );
    }

    @Test
    void should_throw_exception_when_all_questions_answered() {
        // given
        DailyTestRetriever retriever = new DailyTestRetriever(new LearningTaskReadPortEmptyTestImpl(), learningTaskGeneratorFacade, currentUserProvider, clock);
        // when && then
        assertThrows(DailyTestAlreadyCompletedException.class, retriever::retrieveDailyTest);
    }

}
