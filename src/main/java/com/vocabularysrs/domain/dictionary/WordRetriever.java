package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class WordRetriever {

    private final WordEntryRepository wordEntryRepository;

    public boolean isExistByWord(String word) {
        if (wordEntryRepository.existsByWord(word)) {
            throw new WordAlreadyExistsException(word);
        }
        return false;
    }

    void existById(Long id) {
        if (!wordEntryRepository.existsById(id)) {
            throw new WordNotFoundException(id);
        }
    }
}