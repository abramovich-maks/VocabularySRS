package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WordsDtoResponse(
        List<WordDtoResponse> words
) {
}
