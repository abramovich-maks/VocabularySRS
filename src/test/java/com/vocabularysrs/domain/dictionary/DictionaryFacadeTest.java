package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordUpdatePartiallyDtoRequest;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_10_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_15_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_1_DAY;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_25_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_3_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_5_DAYS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DictionaryFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    private final RepetitionIntervalCalculator calculator = new RepetitionIntervalCalculator();
    private final InMemoryWordEntryRepositoryTestImpl repository = new InMemoryWordEntryRepositoryTestImpl();
    WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
    CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    DictionaryFacade dictionaryFacade = new WordEntryConfiguration().dictionaryFacade(repository, currentUserProvider, clock);
    DictionaryUpdateAdapter adapter = new WordEntryConfiguration().dictionaryUpdateAdapter(repository, calculator, clock, currentUserProvider);

    @Test
    public void should_return_success_when_user_gave_new_word_and_translate() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот");
        // when
        WordEntryDtoResponse result = dictionaryFacade.addWord(dtoRequest);
        // then
        assertThat(result.message()).isEqualTo("Success. New word added");
        assertThat(result.word()).isEqualTo("cat");
        assertThat(result.translate()).isEqualTo("кот");
    }

    @Test
    public void should_return_error_when_user_gave_null_word_or_null_translate() {
        // given
        WordAddDtoRequest wordIsNull = new WordAddDtoRequest(null, "кот");
        WordAddDtoRequest translateIsNull = new WordAddDtoRequest("cat", null);
        // when && then
        InvalidWordException word = assertThrows(InvalidWordException.class, () -> dictionaryFacade.addWord(wordIsNull));
        assertThat(word.getMessage()).isEqualTo("Word must not be null");

        InvalidWordException translate = assertThrows(InvalidWordException.class, () -> dictionaryFacade.addWord(translateIsNull));
        assertThat(translate.getMessage()).isEqualTo("Translate must not be null");
    }

    @Test
    public void should_throw_an_exception_when_word_already_exist() {
        // given
        WordAddDtoRequest word_1 = new WordAddDtoRequest("cat", "кот");
        WordAddDtoRequest word_2 = new WordAddDtoRequest("cat", "кот");
        // when
        dictionaryFacade.addWord(word_1);
        // then
        WordAlreadyExistsException wordAlreadyExistsException = assertThrows(WordAlreadyExistsException.class, () -> dictionaryFacade.addWord(word_2));
        assertThat(wordAlreadyExistsException.getMessage()).isEqualTo("Word \"cat\" already exists");
    }

    @Test
    public void should_save_date_created() {
        // given
        WordEntry entry = WordEntry.builder()
                .word("cat")
                .translate("кот")
                .build();
        Assertions.assertNull(entry.getDateAdded());
        Assertions.assertNull(entry.getNextReviewDate());

        // when
        entry.initialize(clock.today());
        // then
        Assertions.assertNotNull(entry.getDateAdded());
        Assertions.assertNotNull(entry.getNextReviewDate());

        LocalDate today = clock.today();
        Assertions.assertEquals(today, entry.getDateAdded());

        LocalDate nextReviewDate = today.plusDays(INTERVAL_1_DAY.getDays());
        Assertions.assertEquals(nextReviewDate, entry.getNextReviewDate());
    }

    @Test
    public void should_throw_an_exception_when_user_want_delete_by_id_not_exist_word() {
        // given
        // when
        WordNotFoundException wordAlreadyExistsException = assertThrows(WordNotFoundException.class, () -> dictionaryFacade.deleteWord(0L));
        // then
        assertThat(wordAlreadyExistsException.getMessage()).isEqualTo("Word with id: 0 not found");
    }

    @Test
    public void should_deleted_message_when_user_want_delete_by_exist_id() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот");
        dictionaryFacade.addWord(dtoRequest);
        // when
        WordEntryDtoResponse result = dictionaryFacade.deleteWord(0L);
        // then
        assertThat(result.message()).isEqualTo("Deleted word by id: 0");
        assertThrows(WordNotFoundException.class, () -> dictionaryFacade.deleteWord(0L));
    }

    @Test
    public void should_return_all_words_entry() {
        // given
        assertThat(dictionaryFacade.findAllWords(Pageable.unpaged())).isEmpty();
        WordAddDtoRequest dtoRequest1 = new WordAddDtoRequest("cat", "кот");
        WordAddDtoRequest dtoRequest2 = new WordAddDtoRequest("cat2", "кот2");
        // when
        dictionaryFacade.addWord(dtoRequest1);
        dictionaryFacade.addWord(dtoRequest2);
        // then
        assertAll(
                () -> assertThat(dictionaryFacade.findAllWords(Pageable.unpaged())).hasSize(2),
                () -> assertThat(dictionaryFacade.findAllWords(Pageable.unpaged())).extracting(WordDtoResponse::word).contains("cat", "cat2")
        );
    }

    @Test
    public void should_return_one_word_entry_by_id() {
        // given
        WordAddDtoRequest dtoRequest1 = new WordAddDtoRequest("cat", "кот");
        WordAddDtoRequest dtoRequest2 = new WordAddDtoRequest("cat2", "кот2");
        dictionaryFacade.addWord(dtoRequest1);
        dictionaryFacade.addWord(dtoRequest2);
        // when
        WordDtoResponse result1 = dictionaryFacade.findById(0L);
        WordDtoResponse result2 = dictionaryFacade.findById(1L);
        // then
        assertAll(
                () -> {
                    Assertions.assertNotNull(result1);
                    assertThat(result1.id()).isEqualTo(0);
                    assertThat(result1.word()).isEqualTo("cat");
                    assertThat(result1.translate()).isEqualTo("кот");
                },
                () -> {
                    Assertions.assertNotNull(result2);
                    assertThat(result2.id()).isEqualTo(1);
                    assertThat(result2.word()).isEqualTo("cat2");
                    assertThat(result2.translate()).isEqualTo("кот2");
                }
        );
    }

    @Test
    public void should_throw_an_exception_when_user_want_get_word_entry_is_not_exist() {
        // given
        // when
        WordNotFoundException wordAlreadyExistsException = assertThrows(WordNotFoundException.class, () -> dictionaryFacade.findById(13L));
        // then
        assertThat(wordAlreadyExistsException.getMessage()).isEqualTo("Word with id: 13 not found");
    }

    @Test
    public void should_return_updated_word() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот");
        dictionaryFacade.addWord(dtoRequest);
        WordUpdatePartiallyDtoRequest updateRequest = WordUpdatePartiallyDtoRequest.builder()
                .word("dog")
                .build();
        // when
        WordEntryUpdateDtoResponse updatedWordEntry = dictionaryFacade.updatePartiallyById(0L, updateRequest);
        // then
        WordDtoResponse result1 = dictionaryFacade.findById(0L);
        assertAll(
                () -> assertThat(updatedWordEntry.message()).isEqualTo("Success. Word entry with id: 0 updated"),
                () -> assertThat(updatedWordEntry.word()).isEqualTo("dog"),
                () -> assertThat(updatedWordEntry.translate()).isEqualTo("кот"),
                () -> {
                    Assertions.assertNotNull(result1);
                    assertThat(result1.id()).isEqualTo(0);
                    assertThat(result1.word()).isEqualTo("dog");
                    assertThat(result1.translate()).isEqualTo("кот");
                });
    }

    @Test
    public void should_return_updated_translate() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот");
        dictionaryFacade.addWord(dtoRequest);
        WordUpdatePartiallyDtoRequest updateRequest = WordUpdatePartiallyDtoRequest.builder()
                .translate("dog")
                .build();
        // when
        WordEntryUpdateDtoResponse updatedWordEntry = dictionaryFacade.updatePartiallyById(0L, updateRequest);
        // then
        WordDtoResponse result1 = dictionaryFacade.findById(0L);
        assertAll(
                () -> assertThat(updatedWordEntry.message()).isEqualTo("Success. Word entry with id: 0 updated"),
                () -> assertThat(updatedWordEntry.word()).isEqualTo("cat"),
                () -> assertThat(updatedWordEntry.translate()).isEqualTo("dog"),
                () -> {
                    Assertions.assertNotNull(result1);
                    assertThat(result1.id()).isEqualTo(0);
                    assertThat(result1.word()).isEqualTo("cat");
                    assertThat(result1.translate()).isEqualTo("dog");
                });
    }

    @Test
    void should_return_words_entry_by_next_review_date() {
        // given
        LocalDate reviewDate = LocalDate.now().plusDays(INTERVAL_1_DAY.getDays());
        // when
        List<WordEntrySnapshot> wordsForReview = wordEntryReadPort.findWordEntriesByNextReviewDate(reviewDate);
        // then
        assertThat(wordsForReview)
                .extracting(WordEntrySnapshot::word)
                .containsExactlyInAnyOrder("cat", "dog", "sun");
    }

    @Test
    void should_map_entities_to_snapshots_for_given_date() {
        // given
        WordAddDtoRequest word_1 = new WordAddDtoRequest("cat", "кот");
        WordAddDtoRequest word_2 = new WordAddDtoRequest("dog", "собака");
        dictionaryFacade.addWord(word_1);
        dictionaryFacade.addWord(word_2);
        WordEntryJpaAdapter adapter = new WordEntryJpaAdapter(repository);
        LocalDate reviewDate = clock.today().plusDays(INTERVAL_1_DAY.getDays());
        // when
        List<WordEntrySnapshot> result = adapter.findWordEntriesByNextReviewDate(reviewDate);
        // then
        assertThat(result)
                .extracting(WordEntrySnapshot::word)
                .containsExactlyInAnyOrder("cat", "dog");
    }

    @Test
    void should_increase_interval_and_update_next_review_date_when_correct() {
        // given
        WordEntry entry = WordEntry.builder()
                .currentInterval(INTERVAL_1_DAY)
                .build();
        // when
        entry.applyReviewResult(true, calculator, clock.today());
        // then
        assertThat(entry.getCurrentInterval()).isEqualTo(INTERVAL_3_DAYS);
        assertThat(entry.getNextReviewDate()).isEqualTo(clock.today().plusDays(3));
    }

    @Test
    void should_decrease_interval_and_update_next_review_date_when_incorrect() {
        // given
        WordEntry entry = WordEntry.builder()
                .currentInterval(INTERVAL_10_DAYS)
                .build();
        // when
        entry.applyReviewResult(false, calculator, clock.today());
        // then
        assertThat(entry.getCurrentInterval()).isEqualTo(INTERVAL_5_DAYS);
        assertThat(entry.getNextReviewDate()).isEqualTo(clock.today().plusDays(5));
    }

    @Test
    void should_update_word_entry_where_user_request_test() {
        // given
        WordEntry entry = WordEntry.builder()
                .userId(1L)
                .currentInterval(INTERVAL_1_DAY)
                .build();
        entry.initialize(clock.today());
        repository.save(entry);
        DailyTestResponseDto response = DailyTestResponseDto.builder()
                .answers(List.of(AnswerResultDto.builder()
                        .wordEntryId(0L)
                        .correct(true)
                        .build()))
                .build();
        // when
        adapter.update(response);
        // then
        WordEntry updated = repository.findByIdAndUserId(0L, 1L).orElseThrow();
        assertThat(updated.getCurrentInterval()).isEqualTo(INTERVAL_3_DAYS);
    }

    @Test
    void should_move_forward_when_answer_is_correct() {
        assertThat(calculator.next(INTERVAL_1_DAY)).isEqualTo(INTERVAL_3_DAYS);
        assertThat(calculator.next(INTERVAL_3_DAYS)).isEqualTo(INTERVAL_5_DAYS);
        assertThat(calculator.next(INTERVAL_5_DAYS)).isEqualTo(INTERVAL_10_DAYS);
        assertThat(calculator.next(INTERVAL_10_DAYS)).isEqualTo(INTERVAL_15_DAYS);
        assertThat(calculator.next(INTERVAL_15_DAYS)).isEqualTo(INTERVAL_25_DAYS);
        assertThat(calculator.next(INTERVAL_25_DAYS)).isEqualTo(INTERVAL_25_DAYS);
    }

    @Test
    void should_move_backward_when_answer_is_incorrect() {
        assertThat(calculator.back(INTERVAL_25_DAYS)).isEqualTo(INTERVAL_15_DAYS);
        assertThat(calculator.back(INTERVAL_15_DAYS)).isEqualTo(INTERVAL_10_DAYS);
        assertThat(calculator.back(INTERVAL_10_DAYS)).isEqualTo(INTERVAL_5_DAYS);
        assertThat(calculator.back(INTERVAL_5_DAYS)).isEqualTo(INTERVAL_3_DAYS);
        assertThat(calculator.back(INTERVAL_3_DAYS)).isEqualTo(INTERVAL_1_DAY);
        assertThat(calculator.back(INTERVAL_1_DAY)).isEqualTo(INTERVAL_1_DAY);
    }

    @Test
    void should_return_only_current_user_words() {
        // given
        ((TestCurrentUserProvider) currentUserProvider).setUserId(1L);
        dictionaryFacade.addWord(new WordAddDtoRequest("cat", "кот"));
        dictionaryFacade.addWord(new WordAddDtoRequest("dog", "собака"));

        ((TestCurrentUserProvider) currentUserProvider).setUserId(2L);
        dictionaryFacade.addWord(new WordAddDtoRequest("sun", "солнце"));
        // when
        ((TestCurrentUserProvider) currentUserProvider).setUserId(1L);
        List<WordDtoResponse> result =
                dictionaryFacade.findAllWords(Pageable.unpaged());
        // then
        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(WordDtoResponse::word)
                .containsExactlyInAnyOrder("cat", "dog");
    }
}
