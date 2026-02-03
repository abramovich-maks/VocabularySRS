package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.vocabularysrs.domain.words.WordsGroupMapper.mapFromWordsGroupToWordsGroupDtoRequest;

@Log4j2
@AllArgsConstructor
class WordsGroupRetriever {

    private final WordsGroupRepository groupRepository;
    private final CurrentUserProvider currentUserProvider;

    void assertGroupNameNotExists(String groupName) {
        Long userId = currentUserProvider.getCurrentUserId();
        if (groupRepository.existsByGroupNameAndUserId(groupName, userId)) {
            log.info("Group with name \"{}\" already exists (User with id:{})", groupName, userId);
            throw new WordsGroupAlreadyExistsException(groupName);
        }
    }

    WordsGroup findEntityById(final Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        return groupRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new WordsGroupNotFoundException(id));
    }

    AllWordsGroupDtoRequest findAllGroupsByUser() {
        Long userId = currentUserProvider.getCurrentUserId();
        List<WordsGroup> allByUserId = groupRepository.findAllByUserId(userId);
        List<WordsGroupDtoRequest> list = mapFromWordsGroupToWordsGroupDtoRequest(allByUserId);
        return AllWordsGroupDtoRequest.builder().group(list).build();
    }

    WordsGroupDtoRequest findGroupById(final Long groupId) {
        Long userId = currentUserProvider.getCurrentUserId();
        WordsGroup wordsGroup = groupRepository.findByIdAndUserId(groupId, userId)
                .orElseThrow(() -> new WordsGroupNotFoundException(groupId));
        return WordsGroupDtoRequest.builder().groupId(wordsGroup.getId()).groupName(wordsGroup.getGroupName()).build();
    }
}
