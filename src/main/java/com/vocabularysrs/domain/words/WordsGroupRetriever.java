package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
                .orElseThrow(
                        () -> new WordsGroupNotFoundException(id));
    }
}
