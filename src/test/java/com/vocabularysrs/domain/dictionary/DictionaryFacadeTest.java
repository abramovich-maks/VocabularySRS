package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}