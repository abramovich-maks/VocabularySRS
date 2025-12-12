package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class WordRetriever {

    private final WordEntryRepository wordEntryRepository;

    public boolean isExist(String word) {
        if (wordEntryRepository.existsByWord(word)) {
            throw new WordAlreadyExistsException(word);
        }
        return false;
    }
}