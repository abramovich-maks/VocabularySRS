package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

@Builder
public record GroupsResponse(
        Long groupId,
        String groupName,
        Integer countWord
) {
}
