package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.AddWordToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class GroupWordAssigner {

    private final WordGroupLinkRepository linkRepository;
    private final WordEntryRepository wordRepository;
    private final WordsGroupRetriever groupRetriever;
    private final CurrentUserProvider currentUserProvider;

    public AddWordsToGroupDtoResponse addWordToGroup(AddWordToGroupDtoRequest request) {
        return assignWordsToGroup(AddWordsToGroupDtoRequest.builder()
                        .groupId(request.groupId())
                        .wordIds(List.of(request.wordId()))
                        .build()
        );
    }

    public AddWordsToGroupDtoResponse addWordsToGroup(AddWordsToGroupDtoRequest request) {
        return assignWordsToGroup(AddWordsToGroupDtoRequest.builder()
                .groupId(request.groupId())
                .wordIds(request.wordIds())
                .build()
        );
    }

    private AddWordsToGroupDtoResponse assignWordsToGroup(AddWordsToGroupDtoRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        WordsGroup group = groupRetriever.findEntityById(request.groupId());

        List<WordEntry> addedWords = new ArrayList<>();

        for (Long wordId : request.wordIds()) {

            WordEntry word = wordRepository.findByIdAndUserId(wordId, userId)
                    .orElseThrow(() -> new WordNotFoundException(wordId));

            if (linkRepository.existsByWord_IdAndGroup_Id(wordId, group.getId())) {
                continue;
            }

            linkRepository.save(
                    WordGroupLink.builder()
                            .word(word)
                            .group(group)
                            .build()
            );

            addedWords.add(word);
        }

        List<WordDtoResponse> list = addedWords.stream()
                .map(w -> WordDtoResponse.builder()
                        .id(w.getId())
                        .word(w.getWord())
                        .translate(w.getTranslate())
                        .build())
                .toList();

        return AddWordsToGroupDtoResponse.builder()
                .groupName(group.getGroupName())
                .words(list)
                .countAddedWords((long) list.size())
                .build();
    }
}


