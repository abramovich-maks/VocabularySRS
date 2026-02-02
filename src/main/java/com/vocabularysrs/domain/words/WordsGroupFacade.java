package com.vocabularysrs.domain.words;

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

    public CreateGroupDtoResponse createWordsGroup(CreateGroupDtoRequest dtoRequest) {
        return groupAdder.createWordsGroup(dtoRequest);
    }

    public WordsGroupDtoResponse deleteGroup(Long id) {
        return groupDeleter.deleteById(id);
    }
}
