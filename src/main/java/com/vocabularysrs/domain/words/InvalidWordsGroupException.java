package com.vocabularysrs.domain.words;

public class InvalidWordsGroupException extends RuntimeException {
    public InvalidWordsGroupException(String message) {
        super(message);
    }

    static InvalidWordsGroupException nameIsNull() {
        return new InvalidWordsGroupException("Group name must not be null");
    }
}
