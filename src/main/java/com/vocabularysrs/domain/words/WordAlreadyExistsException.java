package com.vocabularysrs.domain.words;

public class WordAlreadyExistsException extends RuntimeException {

    public final String word;

    public WordAlreadyExistsException(String word) {
        super("Word \"" + word + "\" already exists");
        this.word = word;
    }
}
