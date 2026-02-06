package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

@Builder
public record UpdateGroupRequest(
        Long groupId,
        String newGroupName
) {
}
