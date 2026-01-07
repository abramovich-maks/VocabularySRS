package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class LearningTaskGeneratorFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    CurrentUserProvider user = new TestCurrentUserProvider();

    @Test
    void should_generate_two_questions_for_single_word() {
        // given
        WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
        InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
        LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordRepository, wordEntryReadPort);
        // when
        LearningTaskDto learningTaskDto = learningTaskGeneratorFacade.generateForUser(clock.today(), user.getCurrentUserId());
        // then
        assertThat(learningTaskDto.questions()).hasSize(2);
        assertThat(learningTaskDto.questions())
                .extracting("prompt", "direction")
                .containsExactlyInAnyOrder(
                        tuple("cat", TranslationDirection.WORD_TO_TRANSLATION),
                        tuple("кот", TranslationDirection.TRANSLATION_TO_WORD)
                );
    }

    @Test
    void should_generate_tasks_only_for_given_user() {
        // given
        WordEntryReadPort wordEntryReadPort = new DailyWordReadPortTwoUsersTestImpl();
        InMemoryLearningTaskRepositoryTestImpl dailyWordRepository = new InMemoryLearningTaskRepositoryTestImpl();
        LearningTaskGeneratorFacade learningTaskGeneratorFacade = new LearningTaskGeneratorConfiguration().learningTaskGeneratorFacade(dailyWordRepository, wordEntryReadPort);
        // when
        LearningTaskDto taskUser1 = learningTaskGeneratorFacade.generateForUser(clock.today(), 1L);
        LearningTaskDto taskUser2 = learningTaskGeneratorFacade.generateForUser(clock.today(), 2L);

        // then
        assertThat(taskUser1.userId()).isEqualTo(1L);
        assertThat(taskUser1.questions())
                .extracting("prompt")
                .containsExactlyInAnyOrder("cat", "кот");

        assertThat(taskUser2.userId()).isEqualTo(2L);
        assertThat(taskUser2.questions())
                .extracting("prompt")
                .containsExactlyInAnyOrder("dog", "собака");
    }
}