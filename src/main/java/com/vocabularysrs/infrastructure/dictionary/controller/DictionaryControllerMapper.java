package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.words.dto.WordsDtoResponse;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.UpdateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.AllGroupsResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.AssignWordToGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.AssignWordsToGroupRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.AssignWordsToGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeleteGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.GroupsResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.UpdateGroupRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.UpdateGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordUpdatePartiallyDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordsGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordsResponse;

import java.util.List;

class DictionaryControllerMapper {

    public static WordEntryControllerDtoResponse mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse(final WordEntryDtoResponse newWordEntry) {
        return WordEntryControllerDtoResponse.builder()
                .id(newWordEntry.id())
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
        List<GroupsResponse> allGroups = allGroupByUser.group().stream()
                .map(group -> GroupsResponse.builder()
                        .groupId(group.groupId())
                        .groupName(group.groupName())
                        .countWord(group.countWord())
                        .build())
                .toList();
        return AllGroupsResponse.builder().groups(allGroups).build();
    }

    public static UpdateGroupResponse mapFromWordsGroupDtoRequestToUpdateGroupResponse(final WordsGroupDtoRequest updatedGroup) {
        return UpdateGroupResponse.builder().groupId(updatedGroup.groupId()).groupName(updatedGroup.groupName()).build();
    }

    public static UpdateGroupDtoRequest mapFromUpdateGroupRequestToUpdateGroupDtoRequest(final UpdateGroupRequest request) {
        return UpdateGroupDtoRequest.builder().newGroupName(request.newGroupName()).build();
    }

    public static DeleteGroupResponse mapFromWordsGroupDtoResponseToDeleteGroupResponse(final WordsGroupDtoResponse wordsGroupDtoResponse) {
        return DeleteGroupResponse.builder().groupName(wordsGroupDtoResponse.groupName()).message(wordsGroupDtoResponse.message()).build();
    }

    public static AddWordsToGroupDtoRequest mapFromAssignWordsToGroupRequestToAddWordsToGroupDtoRequest(final AssignWordsToGroupRequest request) {
        return AddWordsToGroupDtoRequest.builder().wordIds(request.wordIds()).build();
    }

    public static AssignWordsToGroupResponse mapFromAddWordsToGroupDtoResponseToAssignWordsToGroupResponse(final AddWordsToGroupDtoResponse assign) {
        return AssignWordsToGroupResponse.builder().groupName(assign.groupName()).words(assign.words()).countAddedWords(assign.countAddedWords()).build();
    }

    public static WordsGroupResponse mapFromWordsGroupDtoRequestToWordsGroupResponse(final WordsGroupDtoRequest group) {
        return WordsGroupResponse.builder().groupId(group.groupId()).groupName(group.groupName()).words(group.words()).build();
    }

    public static WordsResponse mapFromWordsDtoResponseToWordsResponse(final WordsDtoResponse availableWords) {
        List<WordDtoControllerResponse> words = availableWords.words().stream()
                .map(word -> WordDtoControllerResponse.builder()
                        .id(word.id())
                        .word(word.word())
                        .translate(word.translate())
                        .build())
                .toList();

        return WordsResponse.builder()
                .words(words)
                .build();
    }

    public  static AssignWordToGroupResponse mapFromAddWordsToGroupDtoResponseToAssignWordToGroupResponse(final AddWordsToGroupDtoResponse assign) {
        WordDtoResponse word = assign.words().stream().findFirst().orElseThrow(() -> new IllegalStateException("Word was not added to group"));
        WordDtoControllerResponse build = WordDtoControllerResponse.builder().id(word.id()).word(word.word()).translate(word.translate()).build();
        return AssignWordToGroupResponse.builder().groupName(assign.groupName()).word(build).build();
    }
}
