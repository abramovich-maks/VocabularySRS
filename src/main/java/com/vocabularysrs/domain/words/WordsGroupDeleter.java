package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static java.lang.String.format;

@AllArgsConstructor
@Log4j2
class WordsGroupDeleter {

    private final WordsGroupRepository groupRepository;
    private final WordsGroupRetriever wordsGroupRetriever;
    private final WordGroupLinkRepository linkRepository;


    WordsGroupDtoResponse deleteById(final Long groupId) {
        WordsGroup group = wordsGroupRetriever.findEntityById(groupId);

        linkRepository.deleteByGroup_Id(groupId);
        groupRepository.delete(group);
        log.info("Deleted group by id: {}, userId: {}", groupId, group.getUserId());
        return WordsGroupDtoResponse.builder()
                .message(format("Deleted group by id: %s", groupId))
                .build();
    }
}
