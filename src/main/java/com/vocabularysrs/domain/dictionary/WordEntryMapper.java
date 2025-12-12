package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;

class WordEntryMapper {
    public static WordEntry mapFromWordAddDtoRequestToWordEntry(final WordAddDtoRequest dtoRequest) {
        return WordEntry.builder()
                .word(dtoRequest.word())
                .translate(dtoRequest.translate())
                .build();
    }

    public static WordEntryDtoResponse mapFromWordEntryToWordEntryDtoResponse(final WordEntry save) {
        return WordEntryDtoResponse.builder()
                .word(save.getWord())
                .translate(save.getTranslate())
                .message("Success. New word added")
                .build();
    }
}
