package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record WordsGroupResponse(
        Long groupId,
        String groupName,
        List<WordDtoResponse> words
) {
}
