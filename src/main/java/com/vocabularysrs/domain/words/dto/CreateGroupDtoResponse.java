package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record CreateGroupDtoResponse(
        Long groupId,
        String groupName,
        String message
) {
}