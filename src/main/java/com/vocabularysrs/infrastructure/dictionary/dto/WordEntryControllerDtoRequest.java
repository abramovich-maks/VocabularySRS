package com.vocabularysrs.infrastructure.dictionary.dto;

public record WordEntryControllerDtoRequest(
        String word,
        String translate
) {
}
