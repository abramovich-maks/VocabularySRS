package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record DeleteGroupResponse(
        String groupName,
        String message
) {
}
