package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class WordsGroupFacade {

    private final WordsGroupAdder groupAdder;
    private final WordsGroupDeleter groupDeleter;
    private final WordsGroupRetriever groupRetriever;

    public CreateGroupDtoResponse createWordsGroup(CreateGroupDtoRequest dtoRequest) {
        return groupAdder.createWordsGroup(dtoRequest);
    }

    public WordsGroupDtoResponse deleteGroup(Long id) {
        return groupDeleter.deleteById(id);
    }

    public AllWordsGroupDtoRequest findAllGroupByUser() {
        return groupRetriever.findAllGroupsByUser();
    }
}
