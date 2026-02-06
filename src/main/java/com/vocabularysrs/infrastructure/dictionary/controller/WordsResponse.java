package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record WordsResponse(
        List<WordDtoControllerResponse> words
) {
}
