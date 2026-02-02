package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static java.lang.String.format;

@AllArgsConstructor
@Log4j2
class WordsGroupDeleter {

    private final WordsGroupRepository groupRepository;
    private final WordsGroupRetriever wordsGroupRetriever;
    private final WordEntryRepository wordEntryRepository;
    private final CurrentUserProvider currentUserProvider;


    WordsGroupDtoResponse deleteById(final Long groupId) {
        WordsGroup group = wordsGroupRetriever.findEntityById(groupId);

        Long userId = currentUserProvider.getCurrentUserId();
        List<WordEntry> words = wordEntryRepository.findAllByUserIdAndGroup_Id(userId, groupId);
        words.forEach(WordEntry::removeFromGroup);
        groupRepository.delete(group);
        log.info("Deleted group by id: {}, userId: {}", groupId, group.getUserId());
        return WordsGroupDtoResponse.builder()
                .message(format("Deleted group by id: %s", groupId))
                .build();
    }
}
