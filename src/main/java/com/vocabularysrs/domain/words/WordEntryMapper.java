package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsDtoResponse;

import java.util.List;

import static java.lang.String.format;

class WordEntryMapper {
    public static WordEntry mapFromWordAddDtoRequestToWordEntry(final WordAddDtoRequest dtoRequest) {
        return WordEntry.builder()
                .word(dtoRequest.word())
                .translate(dtoRequest.translate())
                .build();
    }

    public static WordEntryDtoResponse mapFromWordEntryToWordEntryDtoResponse(final WordEntry save) {
        return WordEntryDtoResponse.builder()
                .id(save.getId())
                .word(save.getWord())
                .translate(save.getTranslate())
                .message("Success. New word added")
                .build();
    }

    public static WordDtoResponse mapFromWordEntryToWordDtoResponse(final WordEntry wordEntry) {
        return WordDtoResponse.builder()
                .id(wordEntry.getId())
                .word(wordEntry.getWord())
                .translate(wordEntry.getTranslate())
                .build();
    }

    public static WordEntryUpdateDtoResponse mapFromWordEntryToWordEntryUpdateDtoResponse(final Long id, final WordEntry wordEntry) {
        return WordEntryUpdateDtoResponse.builder()
                .id(wordEntry.getId())
                .word(wordEntry.getWord())
                .translate(wordEntry.getTranslate())
                .message(format("Success. Word entry with id: %s updated", id))
                .build();
    }

    public static WordsDtoResponse mapFromListWordEntryToWordsDtoResponse(final List<WordEntry> availableWords) {
        List<WordDtoResponse> words = availableWords.stream()
                .map(WordEntryMapper::mapFromWordEntryToWordDtoResponse)
                .toList();
        return WordsDtoResponse.builder()
                .words(words)
                .build();
    }
}
