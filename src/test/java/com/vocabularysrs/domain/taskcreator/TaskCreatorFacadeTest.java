package com.vocabularysrs.domain.taskcreator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskCreatorFacadeTest {

    WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
    ReviewTaskRepository reviewTaskRepository = new InMemoryReviewTaskRepositoryTestImpl();
    CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    TaskCreatorFacade taskCreatorFacade = new TaskCreatorConfiguration().taskCreatorFacade(wordEntryReadPort, reviewTaskRepository, currentUserProvider);

    @Test
    void should_create_daily_task_with_two_items() {
        // given
        LocalDate today = LocalDate.now();
        // when
        ReviewTask dailyTask = taskCreatorFacade.createDailyTask();
        // then
        assertThat(dailyTask.getTaskDate()).isEqualTo(today);
        assertThat(dailyTask.getItems()).hasSize(2);
        assertThat(
                dailyTask.getItems().stream()
                        .map(ReviewTaskItem::getWordEntryId)
        ).containsExactlyInAnyOrder(0L, 1L);
    }

    @Test
    void should_throw_exception_when_daily_task_already_exists() {
        // given
        LocalDate today = LocalDate.now();
        taskCreatorFacade.createDailyTask();
        // when
        TaskAlreadyExist thrownException = assertThrows(TaskAlreadyExist.class, () -> taskCreatorFacade.createDailyTask());
        assertThat(thrownException.getMessage()).isEqualTo("Task at " + today + " already exist!");
    }
}