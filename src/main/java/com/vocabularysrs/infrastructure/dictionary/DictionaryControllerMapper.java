package com.vocabularysrs.infrastructure.dictionary;

import com.vocabularysrs.domain.dictionary.WordEntryDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;

class DictionaryControllerMapper {

    public static WordEntryControllerDtoResponse mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse(final WordEntryDtoResponse newWordEntry) {
        return WordEntryControllerDtoResponse.builder()
                .word(newWordEntry.word())
                .translate(newWordEntry.translate())
                .message(newWordEntry.message())
                .build();
    }

    public static WordAddDtoRequest mapFromWordEntryControllerDtoRequestToWordAddDtoRequest(final WordEntryControllerDtoRequest dtoRequest) {
        return WordAddDtoRequest.builder()
                .word(dtoRequest.word())
                .translate(dtoRequest.translate())
                .build();
    }
}
