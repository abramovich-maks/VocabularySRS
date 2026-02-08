package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.vocabularysrs.domain.words.WordsGroupMapper.mapFromWordsGroupToCreateGroupDtoResponse;

@AllArgsConstructor
@Log4j2
class WordsGroupAdder {

    private final WordsGroupRetriever groupRetriever;
    private final WordsGroupRepository groupRepository;
    private final CurrentUserProvider currentUserProvider;

    public CreateGroupDtoResponse createWordsGroup(CreateGroupDtoRequest dtoRequest) {
        if (dtoRequest.groupName() == null) {
            throw InvalidWordsGroupException.nameIsNull();
        }

        String groupName = dtoRequest.groupName().trim();
        groupRetriever.assertGroupNameNotExists(groupName);

        WordsGroup newGroup = WordsGroup.builder()
                .groupName(groupName)
                .build();
        Long userId = currentUserProvider.getCurrentUserId();
        newGroup.setUserId(userId);
        WordsGroup save = groupRepository.save(newGroup);
        log.info("User {} created group {} with name '{}'", userId, save.getId(), save.getGroupName());
        return mapFromWordsGroupToCreateGroupDtoResponse(save);
    }
}
