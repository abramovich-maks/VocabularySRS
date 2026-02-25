package com.vocabularysrs.domain.globalwords;

public class GlobalWordNotFoundException extends RuntimeException {
    public final String word;

    public GlobalWordNotFoundException(final String word) {
        super("Global word: \"" + word + "\" not found");
        this.word = word;
    }
}
