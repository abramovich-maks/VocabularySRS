package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record GroupsResponse(
        Long groupId,
        String groupName,
        Integer countWord
) {
}
