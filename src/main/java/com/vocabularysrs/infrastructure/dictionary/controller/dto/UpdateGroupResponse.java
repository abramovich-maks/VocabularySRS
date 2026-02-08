package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record UpdateGroupResponse(
        Long groupId,
        String groupName
) {
}