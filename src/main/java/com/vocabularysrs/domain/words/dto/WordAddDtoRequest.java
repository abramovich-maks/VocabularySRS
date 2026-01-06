package com.vocabularysrs.domain.words.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import static com.vocabularysrs.infrastructure.apivalidation.ValidationConstants.*;

@Builder
public record WordAddDtoRequest(
        @Size( min = WORD_MIN_SIZE,max = WORD_MAX_SIZE, message = "{word.size}")
        String word,

        @Size(min = TRANSLATE_MIN_SIZE, max = TRANSLATE_MAX_SIZE, message = "{translate.size}")
        String translate
) {
}
