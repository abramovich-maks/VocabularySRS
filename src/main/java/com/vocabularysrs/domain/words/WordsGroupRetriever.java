package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.vocabularysrs.domain.words.WordsGroupMapper.mapFromWordsGroupToWordsGroupDtoRequest;

@Log4j2
@AllArgsConstructor
class WordsGroupRetriever {

    private final WordsGroupRepository groupRepository;
    private final WordGroupLinkRepository linkRepository;
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
        List<WordsGroup> groups = groupRepository.findAllByUserId(userId);

        List<WordsGroupDtoRequest> list = groups.stream()
                .map(this::getWordsGroupDtoRequest)
                .toList();

        return AllWordsGroupDtoRequest.builder()
                .group(list)
                .build();
    }

    WordsGroupDtoRequest findGroupById(final Long groupId) {
        Long userId = currentUserProvider.getCurrentUserId();
        WordsGroup wordsGroup = groupRepository.findByIdAndUserId(groupId, userId)
                .orElseThrow(() -> new WordsGroupNotFoundException(groupId));
        return getWordsGroupDtoRequest(wordsGroup);
    }

    private WordsGroupDtoRequest getWordsGroupDtoRequest(final WordsGroup group) {
        List<WordGroupLink> links =
                linkRepository.findAllWithWordByGroupId(group.getId());

        List<WordDtoResponse> words = links.stream()
                .map(link -> WordDtoResponse.builder()
                        .id(link.getWord().getId())
                        .word(link.getWord().getWord())
                        .translate(link.getWord().getTranslate())
                        .build())
                .toList();

        return WordsGroupDtoRequest.builder()
                .groupId(group.getId())
                .groupName(group.getGroupName())
                .words(words)
                .build();
    }
}
