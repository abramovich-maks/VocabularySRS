package com.vocabularysrs.domain.words.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.TRANSLATE_MAX_SIZE;
import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.TRANSLATE_MIN_SIZE;
import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.WORD_MAX_SIZE;
import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.WORD_MIN_SIZE;

@Builder
public record WordAddDtoRequest(
        @Size(min = WORD_MIN_SIZE, max = WORD_MAX_SIZE, message = "{word.size}")
        String word,

        @Size(min = TRANSLATE_MIN_SIZE, max = TRANSLATE_MAX_SIZE, message = "{translate.size}")
        String translate
) {
}
