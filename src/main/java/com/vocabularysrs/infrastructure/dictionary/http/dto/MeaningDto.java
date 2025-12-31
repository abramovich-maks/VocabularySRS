package com.vocabularysrs.infrastructure.dictionary.http.dto;

import java.util.List;

public record MeaningDto(
        String partOfSpeech,
        List<DefinitionDto> definitions
) {
}