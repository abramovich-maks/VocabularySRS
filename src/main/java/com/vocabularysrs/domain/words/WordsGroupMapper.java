package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;

import java.util.List;

class WordsGroupMapper {

    public static CreateGroupDtoResponse mapFromWordsGroupToCreateGroupDtoResponse(final WordsGroup save) {
        return CreateGroupDtoResponse.builder().groupId(save.getId()).groupName(save.getGroupName()).message("Created new group").build();
    }
    public static List<WordsGroupDtoRequest> mapFromWordsGroupToWordsGroupDtoRequest(final List<WordsGroup> allByUserId) {
        return allByUserId.stream().map(group -> WordsGroupDtoRequest.builder().groupId(group.getId()).groupName(group.getGroupName()).build()).toList();
    }

}
