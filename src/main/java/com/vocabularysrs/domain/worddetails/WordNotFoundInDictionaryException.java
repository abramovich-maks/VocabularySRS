package com.vocabularysrs.domain.worddetails;

public class WordNotFoundInDictionaryException extends RuntimeException {

    public WordNotFoundInDictionaryException(String word) {
        super("Word not found in dictionary: " + word);
    }
}