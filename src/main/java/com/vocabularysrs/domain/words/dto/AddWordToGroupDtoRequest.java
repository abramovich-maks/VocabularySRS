package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record AddWordToGroupDtoRequest(
        Long wordId,
        Long groupId
) {
}
