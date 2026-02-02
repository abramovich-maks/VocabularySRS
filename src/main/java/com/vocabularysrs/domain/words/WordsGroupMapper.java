package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;

class WordsGroupMapper {

    public static CreateGroupDtoResponse mapFromWordsGroupToCreateGroupDtoResponse(final WordsGroup save) {
        return CreateGroupDtoResponse.builder().groupId(save.getId()).groupName(save.getGroupName()).message("Created new group").build();
    }
}
