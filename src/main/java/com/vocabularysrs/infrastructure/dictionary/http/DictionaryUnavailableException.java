package com.vocabularysrs.infrastructure.dictionary.http;

public class DictionaryUnavailableException extends RuntimeException {
    public DictionaryUnavailableException(String message) {
        super(message);
    }
}

