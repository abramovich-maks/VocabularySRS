package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AddWordsToGroupDtoResponse(
        String groupName,
        List<WordDtoResponse> words,
        Long countAddedWords
) {
}
