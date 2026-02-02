package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordsGroupDtoResponse(
        String groupName,
        String message
) {
}
