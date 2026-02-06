package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record WordsDtoResponse(
        List<WordDtoResponse> words
) {
}
