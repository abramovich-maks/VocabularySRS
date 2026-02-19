package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.worddetails.WordDetailsDeleter;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordUpdatePartiallyDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsDtoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_10_DAYS;
import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_15_DAYS;
import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_1_DAY;
import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_25_DAYS;
import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_3_DAYS;
import static com.vocabularysrs.domain.words.RepetitionInterval.INTERVAL_5_DAYS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsFacadeTest {

    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    private final RepetitionIntervalCalculator calculator = new RepetitionIntervalCalculator();
    private final InMemoryWordEntryRepositoryTestImpl repository = new InMemoryWordEntryRepositoryTestImpl();
    private final WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
    private final CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    private final WordDetailsDeleter wordDetailsDeleter = new WordDetailsDeleteTestImpl();
    private final InMemoryTranslationServiceTestImpl translationService = new InMemoryTranslationServiceTestImpl();
    private final InMemoryFetcherTestImpl fetcherTest = new InMemoryFetcherTestImpl();
    private final WordsGroupRepository wordsGroupRepository = new InMemoryWordsGroupRepositoryTestImpl();
    private final WordGroupLinkRepository linkRepository = new InMemoryWordGroupLinkRepositoryTestImpl();
    private final WordsFacade wordsFacade = new WordEntryConfiguration().dictionaryFacade(repository, currentUserProvider, clock, wordDetailsDeleter, translationService, fetcherTest, wordsGroupRepository, linkRepository);
    private final WordEntryUpdateAdapter adapter = new WordEntryConfiguration().dictionaryUpdateAdapter(repository, calculator, clock, currentUserProvider);
    private final WordsGroupFacade wordsGroupFacade = new WordEntryConfiguration().wordsGroupFacade(wordsGroupRepository, currentUserProvider, linkRepository, repository);


    @Test
    public void should_return_success_when_user_gave_new_word_and_translate() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот", null);
        // when
        WordEntryDtoResponse result = wordsFacade.addWord(dtoRequest);
        // then
        assertThat(result.message()).isEqualTo("Success. New word added");
        assertThat(result.word()).isEqualTo("cat");
        assertThat(result.translate()).isEqualTo("кот");
    }

    @Test
    public void should_return_error_when_user_gave_null_word_or_null_translate() {
        // given
        WordAddDtoRequest wordIsNull = new WordAddDtoRequest(null, "кот", null);
        WordAddDtoRequest translateIsNull = new WordAddDtoRequest("cat", null, null);
        // when && then
        InvalidWordException word = assertThrows(InvalidWordException.class, () -> wordsFacade.addWord(wordIsNull));
        assertThat(word.getMessage()).isEqualTo("Word must not be null");

        InvalidWordException translate = assertThrows(InvalidWordException.class, () -> wordsFacade.addWord(translateIsNull));
        assertThat(translate.getMessage()).isEqualTo("Translate must not be null");
    }

    @Test
    public void should_throw_an_exception_when_word_already_exist() {
        // given
        WordAddDtoRequest word_1 = new WordAddDtoRequest("cat", "кот", null);
        WordAddDtoRequest word_2 = new WordAddDtoRequest("cat", "кот", null);
        // when
        wordsFacade.addWord(word_1);
        // then
        WordAlreadyExistsException wordAlreadyExistsException = assertThrows(WordAlreadyExistsException.class, () -> wordsFacade.addWord(word_2));
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
        WordNotFoundException wordAlreadyExistsException = assertThrows(WordNotFoundException.class, () -> wordsFacade.deleteWord(0L));
        // then
        assertThat(wordAlreadyExistsException.getMessage()).isEqualTo("Word with id: 0 not found");
    }

    @Test
    public void should_deleted_message_when_user_want_delete_by_exist_id() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот", null);
        wordsFacade.addWord(dtoRequest);
        // when
        WordEntryDtoResponse result = wordsFacade.deleteWord(0L);
        // then
        assertThat(result.message()).isEqualTo("Deleted word by id: 0");
        assertThrows(WordNotFoundException.class, () -> wordsFacade.deleteWord(0L));
    }

    @Test
    public void should_return_all_words_entry() {
        // given
        assertThat(wordsFacade.findAllWords().words()).isEmpty();
        WordAddDtoRequest dtoRequest1 = new WordAddDtoRequest("cat", "кот", null);
        WordAddDtoRequest dtoRequest2 = new WordAddDtoRequest("cat2", "кот2", null);
        // when
        wordsFacade.addWord(dtoRequest1);
        wordsFacade.addWord(dtoRequest2);
        // then
        assertAll(
                () -> assertThat(wordsFacade.findAllWords().words()).hasSize(2),
                () -> assertThat(wordsFacade.findAllWords().words()).extracting(WordDtoResponse::word).contains("cat", "cat2")
        );
    }

    @Test
    public void should_return_one_word_entry_by_id() {
        // given
        WordAddDtoRequest dtoRequest1 = new WordAddDtoRequest("cat", "кот", null);
        WordAddDtoRequest dtoRequest2 = new WordAddDtoRequest("cat2", "кот2", null);
        wordsFacade.addWord(dtoRequest1);
        wordsFacade.addWord(dtoRequest2);
        // when
        WordDtoResponse result1 = wordsFacade.findById(0L);
        WordDtoResponse result2 = wordsFacade.findById(1L);
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
        WordNotFoundException wordAlreadyExistsException = assertThrows(WordNotFoundException.class, () -> wordsFacade.findById(13L));
        // then
        assertThat(wordAlreadyExistsException.getMessage()).isEqualTo("Word with id: 13 not found");
    }

    @Test
    public void should_return_updated_word() {
        // given
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот", null);
        wordsFacade.addWord(dtoRequest);
        WordUpdatePartiallyDtoRequest updateRequest = WordUpdatePartiallyDtoRequest.builder()
                .word("dog")
                .build();
        // when
        WordEntryUpdateDtoResponse updatedWordEntry = wordsFacade.updatePartiallyById(0L, updateRequest);
        // then
        WordDtoResponse result1 = wordsFacade.findById(0L);
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
        WordAddDtoRequest dtoRequest = new WordAddDtoRequest("cat", "кот", null);
        wordsFacade.addWord(dtoRequest);
        WordUpdatePartiallyDtoRequest updateRequest = WordUpdatePartiallyDtoRequest.builder()
                .translate("dog")
                .build();
        // when
        WordEntryUpdateDtoResponse updatedWordEntry = wordsFacade.updatePartiallyById(0L, updateRequest);
        // then
        WordDtoResponse result1 = wordsFacade.findById(0L);
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
        List<WordEntrySnapshot> wordsForReview = wordEntryReadPort.findWordEntriesByNextReviewDateAndUserIdLessThanEqual(reviewDate, currentUserProvider.getCurrentUserId());
        // then
        assertThat(wordsForReview)
                .extracting(WordEntrySnapshot::word)
                .containsExactlyInAnyOrder("cat", "dog", "sun");
    }

    @Test
    void should_map_entities_to_snapshots_for_given_date() {
        // given
        WordAddDtoRequest word_1 = new WordAddDtoRequest("cat", "кот", null);
        WordAddDtoRequest word_2 = new WordAddDtoRequest("dog", "собака", null);
        wordsFacade.addWord(word_1);
        wordsFacade.addWord(word_2);
        WordEntryJpaAdapter adapter = new WordEntryJpaAdapter(repository);
        LocalDate reviewDate = clock.today().plusDays(INTERVAL_1_DAY.getDays());
        // when
        List<WordEntrySnapshot> result = adapter.findWordEntriesByNextReviewDateAndUserIdLessThanEqual(reviewDate, currentUserProvider.getCurrentUserId());
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
        wordsFacade.addWord(new WordAddDtoRequest("cat", "кот", null));
        wordsFacade.addWord(new WordAddDtoRequest("dog", "собака", null));

        ((TestCurrentUserProvider) currentUserProvider).setUserId(2L);
        wordsFacade.addWord(new WordAddDtoRequest("sun", "солнце", null));
        // when
        ((TestCurrentUserProvider) currentUserProvider).setUserId(1L);
        WordsDtoResponse result =
                wordsFacade.findAllWords();
        // then
        assertThat(result.words()).hasSize(2);
        assertThat(result.words())
                .extracting(WordDtoResponse::word)
                .containsExactlyInAnyOrder("cat", "dog");
    }

    @Test
    void should_add_word_to_group() {
        // given
        CreateGroupDtoResponse group = wordsGroupFacade.createWordsGroup(new CreateGroupDtoRequest("Animals"));
        WordEntry savedWord = repository.save(WordEntry.builder()
                .word("cat")
                .translate("кот")
                .userId(currentUserProvider.getCurrentUserId()).build());
        // when
        AddWordsToGroupDtoResponse response = wordsFacade.addWordToGroup(group.groupId(), savedWord.getId());
        // then
        assertThat(response.countAddedWords()).isEqualTo(1);
    }
}
