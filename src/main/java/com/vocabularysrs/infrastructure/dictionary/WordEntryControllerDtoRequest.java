package com.vocabularysrs.infrastructure.dictionary;

public record WordEntryControllerDtoRequest(
        String word,
        String translate
) {
}
