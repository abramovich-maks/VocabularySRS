package com.vocabularysrs.domain.words;

class WordNotFoundException extends RuntimeException {

    public final Long wordId;

    public WordNotFoundException(Long wordId) {
        super("Word with id: " + wordId + " not found");
        this.wordId = wordId;
    }
}


