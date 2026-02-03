package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordsGroupDtoRequest(
        Long groupId,
        String groupName
) {
}
