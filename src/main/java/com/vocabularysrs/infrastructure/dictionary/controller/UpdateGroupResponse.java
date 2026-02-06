package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

@Builder
public record UpdateGroupResponse(
        Long groupId,
        String groupName
) {
}