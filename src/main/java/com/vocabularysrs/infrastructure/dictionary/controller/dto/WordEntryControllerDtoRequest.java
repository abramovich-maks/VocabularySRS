package com.vocabularysrs.infrastructure.dictionary.controller.dto;

public record WordEntryControllerDtoRequest(
        String word,
        String translate
) {
}
