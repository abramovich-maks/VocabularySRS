package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import jakarta.validation.constraints.Size;

import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.WORD_MAX_SIZE;
import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.WORD_MIN_SIZE;

public record WordEntryWithAutoTranslateControllerDtoRequest(
        @Size(min = WORD_MIN_SIZE, max = WORD_MAX_SIZE, message = "{word.size}")
        String word
) {
}
