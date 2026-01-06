package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.worddetails.dto.WordHttpDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordDetailsFacade {

    private final WordDetailsRetriever wordDetailsRetriever;

    public WordHttpDto getOrLoad(Long wordId) {
        return wordDetailsRetriever.getOrLoad(wordId);
    }
}
