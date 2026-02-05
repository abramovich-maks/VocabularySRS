package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record CreateGroupResponse(
        Long groupId,
        String groupName,
        String message
) {
}
