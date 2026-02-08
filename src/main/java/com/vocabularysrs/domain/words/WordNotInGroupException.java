package com.vocabularysrs.domain.words;

class WordNotInGroupException extends RuntimeException {

    public WordNotInGroupException(Long wordId, Long groupId) {
        super("Word " + wordId + " is not assigned to group " + groupId);
    }
}
