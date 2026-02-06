package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.UpdateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
class WordsGroupUpdater {

    private final WordsGroupRetriever groupRetriever;


    WordsGroupDtoRequest updateGroupNameById(Long groupId, final UpdateGroupDtoRequest dtoRequest) {
        String newGroupName = dtoRequest.newGroupName();

        if (newGroupName == null) {
            throw InvalidWordsGroupException.nameIsNull();
        }

        groupRetriever.assertGroupNameNotExists(newGroupName);
        WordsGroup group = groupRetriever.findEntityById(groupId);

        String oldGroupName = group.getGroupName();

        group.setGroupName(newGroupName);
        log.info("Group with id:{} was change name from {} to {}", groupId, oldGroupName, newGroupName);
        return WordsGroupDtoRequest.builder().groupId(group.getId()).groupName(group.getGroupName()).build();
    }
}