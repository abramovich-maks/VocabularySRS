package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
public class DictionaryFacade {

    private final WordAdder wordAdder;
    private final WordDeleter wordDeleter;

    public WordEntryDtoResponse addWord(WordAddDtoRequest dtoRequest) {
        return wordAdder.addWord(dtoRequest);
    }

    public WordEntryDtoResponse deleteWord(Long id) {
        return wordDeleter.deleteById(id);
    }
}
