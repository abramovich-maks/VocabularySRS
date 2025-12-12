package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DictionaryFacade {

    private final WordAdder wordAdder;

    public WordEntryDtoResponse addWord(WordAddDtoRequest dtoRequest) {
        return wordAdder.addWord(dtoRequest);
    }
}
