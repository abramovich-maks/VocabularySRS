package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DictionaryFacadeTest {

    DictionaryFacade dictionaryFacade = new WordEntryConfiguration().dictionaryFacade(new InMemoryWordEntryRepositoryTestImpl());

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
        WordAddDtoRequest word_1 = new WordAddDtoRequest(null, "кот");
        WordAddDtoRequest word_2 = new WordAddDtoRequest("cat", null);
        // when
        WordEntryDtoResponse result_1 = dictionaryFacade.addWord(word_1);
        WordEntryDtoResponse result_2 = dictionaryFacade.addWord(word_2);
        // then
        assertThat(result_1.message()).isEqualTo("Word or translate can't be null");
        assertThat(result_1.word()).isNull();
        assertThat(result_2.translate()).isNull();
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
        entry.onCreate();
        // then
        Assertions.assertNotNull(entry.getDateAdded());
        Assertions.assertNotNull(entry.getNextReviewDate());

        LocalDate today = LocalDate.now();
        Assertions.assertEquals(today, entry.getDateAdded());

        LocalDate nextReviewDate = today.plusDays(RepetitionInterval.INTERVAL_1_DAY.getDays());
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
}
