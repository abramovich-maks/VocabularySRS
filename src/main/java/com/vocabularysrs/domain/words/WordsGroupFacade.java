package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
public class WordsGroupFacade {

    private final WordsGroupAdder groupAdder;

    public CreateGroupDtoResponse createWordsGroup(CreateGroupDtoRequest dtoRequest) {
        return groupAdder.createWordsGroup(dtoRequest);
    }
}
