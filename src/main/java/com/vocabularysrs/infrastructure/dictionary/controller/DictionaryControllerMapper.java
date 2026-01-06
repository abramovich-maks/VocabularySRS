package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.worddetails.WordHttpDto;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.GetAllWordsResponseDto;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordUpdatePartiallyDtoResponse;

import java.util.List;
import java.util.stream.Collectors;

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

    public static DeletedWordEntryControllerDtoResponse mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse(final WordEntryDtoResponse deletedWordEntry) {
        return DeletedWordEntryControllerDtoResponse.builder()
                .message(deletedWordEntry.message())
                .build();
    }

    public static WordDtoControllerResponse mapFromWordDtoResponseToWordDtoControllerResponse(WordDtoResponse dtoResponse) {
        return WordDtoControllerResponse.builder()
                .id(dtoResponse.id())
                .word(dtoResponse.word())
                .translate(dtoResponse.translate())
                .build();
    }

    public static GetAllWordsResponseDto mapFromWordDtoresponseToGetAllWordsResponseDto(List<WordDtoResponse> songs) {
        List<WordDtoControllerResponse> dtos = songs.stream()
                .map(DictionaryControllerMapper::mapFromWordDtoResponseToWordDtoControllerResponse)
                .collect(Collectors.toList());
        return new GetAllWordsResponseDto(dtos);
    }

    public static WordUpdatePartiallyDtoResponse mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse(final WordEntryUpdateDtoResponse wordEntryById) {
        return WordUpdatePartiallyDtoResponse.builder()
                .id(wordEntryById.id())
                .word(wordEntryById.word())
                .translate(wordEntryById.translate())
                .message(wordEntryById.message())
                .build();
    }


}
