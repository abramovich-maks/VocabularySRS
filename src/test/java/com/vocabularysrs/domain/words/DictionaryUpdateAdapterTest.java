package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DictionaryUpdateAdapterTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );


    private final RepetitionIntervalCalculator calculator = new RepetitionIntervalCalculator();
    private final InMemoryWordEntryRepositoryTestImpl repository = new InMemoryWordEntryRepositoryTestImpl();
    private final TestCurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    private final WordRetriever wordRetriever = new WordRetriever(repository, currentUserProvider);
    private final DictionaryUpdateAdapter adapter = new DictionaryUpdateAdapter(repository, wordRetriever, calculator, clock);

    @Test
    void should_update_word_entry_when_answer_is_correct() {
        // given
        currentUserProvider.setUserId(1L);
        WordEntry entry = WordEntry.builder()
                .userId(1L)
                .currentInterval(RepetitionInterval.INTERVAL_1_DAY)
                .build();
        entry.initialize(clock.today());
        repository.save(entry);
        DailyTestResponseDto response = DailyTestResponseDto.builder().answers(List.of(
                AnswerResult.builder()
                        .wordEntryId(0L)
                        .correct(true)
                        .build()
        )).build();
        // when
        adapter.update(response);
        // then
        WordEntry updated = repository.findByIdAndUserId(0L, 1L).orElseThrow();
        assertEquals(RepetitionInterval.INTERVAL_3_DAYS, updated.getCurrentInterval());
        assertEquals(clock.today().plusDays(3), updated.getNextReviewDate()
        );
    }

    @Test
    void should_skip_update_when_word_does_not_exist() {
        // given
        DailyTestResponseDto response = DailyTestResponseDto.builder().answers(List.of(
                        AnswerResult.builder()
                                .wordEntryId(999L)
                                .correct(true)
                                .build()))
                .build();
        // when && then
        assertDoesNotThrow(() -> adapter.update(response));
        assertTrue(repository.findAllByUserId(response.userId()).isEmpty());
    }
}