package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import jakarta.validation.constraints.Size;

import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.TRANSLATE_MAX_SIZE;
import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.TRANSLATE_MIN_SIZE;
import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.WORD_MAX_SIZE;
import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.WORD_MIN_SIZE;

public record WordEntryControllerDtoRequest(
        @Size(min = WORD_MIN_SIZE, max = WORD_MAX_SIZE, message = "{word.size}")
        String word,

        @Size(min = TRANSLATE_MIN_SIZE, max = TRANSLATE_MAX_SIZE, message = "{translate.size}")
        String translate
) {
}
