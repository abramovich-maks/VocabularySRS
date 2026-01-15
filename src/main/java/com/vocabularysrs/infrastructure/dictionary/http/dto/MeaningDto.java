package com.vocabularysrs.infrastructure.dictionary.http.dto;

import java.util.List;

public record MeaningDto(
        List<DefinitionDto> definitions
) {
}