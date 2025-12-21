package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailywordsselector.DailyWordReadPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class LearningTaskGeneratorFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    @Test
    void should_generate_two_questions_for_single_word() {
        // given
        DailyWordReadPort dailyWordReadPort = new DailyWordReadPortTestImpl();
        InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
        LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordReadPort, dailyWordRepository);
        LocalDate today = LocalDate.now();
        // when
        List<LearningTask> learningTasks = learningTaskGeneratorFacade.generateTasks(clock.today());
        // then
        assertThat(learningTasks).hasSize(1);
        LearningTask task = learningTasks.get(0);
        assertThat(task.getQuestions()).hasSize(2);
        assertThat(task.getQuestions())
                .extracting("prompt", "direction")
                .containsExactlyInAnyOrder(
                        tuple("cat", TranslationDirection.WORD_TO_TRANSLATION),
                        tuple("кот", TranslationDirection.TRANSLATION_TO_WORD)
                );
    }

    @Test
    void should_generate_tasks_for_two_users() {
        // given
        DailyWordReadPort dailyWordReadPortWithTwoUsers = new DailyWordReadPortTwoUsersTestImpl();
        InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
        LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordReadPortWithTwoUsers, dailyWordRepository);
        LocalDate today = LocalDate.now();
        // when
        List<LearningTask> tasks = learningTaskGeneratorFacade.generateTasks(clock.today());
        // then
        assertThat(tasks).hasSize(2);
        // USER1
        LearningTask task1 = tasks.stream()
                .filter(t -> t.getUserId() == 1L)
                .findFirst()
                .orElseThrow();
        assertThat(task1.getQuestions()).hasSize(2);
        assertThat(task1.getQuestions())
                .extracting("prompt", "direction")
                .containsExactlyInAnyOrder(
                        tuple("cat", TranslationDirection.WORD_TO_TRANSLATION),
                        tuple("кот", TranslationDirection.TRANSLATION_TO_WORD)
                );
        // USER2
        LearningTask task2 = tasks.stream()
                .filter(t -> t.getUserId() == 2L)
                .findFirst()
                .orElseThrow();
        assertThat(task2.getQuestions()).hasSize(2);
        assertThat(task2.getQuestions())
                .extracting("prompt", "direction")
                .containsExactlyInAnyOrder(
                        tuple("dog", TranslationDirection.WORD_TO_TRANSLATION),
                        tuple("собака", TranslationDirection.TRANSLATION_TO_WORD)
                );
    }
}