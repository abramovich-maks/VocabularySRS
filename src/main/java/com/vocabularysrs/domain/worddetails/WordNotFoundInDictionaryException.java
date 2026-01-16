package com.vocabularysrs.domain.worddetails;

public class WordNotFoundInDictionaryException extends RuntimeException {

    public WordNotFoundInDictionaryException(String word) {
        super("Unknown word: «" + word + "». Check for typos or enter manually.");
    }
}