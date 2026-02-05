package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordUpdatePartiallyDtoResponse;

import java.util.List;

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


    public static WordUpdatePartiallyDtoResponse mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse(final WordEntryUpdateDtoResponse wordEntryById) {
        return WordUpdatePartiallyDtoResponse.builder()
                .id(wordEntryById.id())
                .word(wordEntryById.word())
                .translate(wordEntryById.translate())
                .message(wordEntryById.message())
                .build();
    }

    public static AllGroupsResponse mapFromAllWordsGroupDtoRequestToAllGroupsResponse(final AllWordsGroupDtoRequest allGroupByUser) {
        List<GroupsResponse> allGroups = allGroupByUser.group().stream().map(group -> GroupsResponse.builder()
                .groupId(group.groupId())
                .groupName(group.groupName()).build()).toList();
        return AllGroupsResponse.builder().groups(allGroups).build();
    }

}
