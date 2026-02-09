package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.GROUP_NAME_MIN_SIZE;
import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.GROUP_NAME_SIZE;

@Builder
public record UpdateGroupRequest(
        Long groupId,

        @Size(min = GROUP_NAME_MIN_SIZE, max = GROUP_NAME_SIZE, message = "{group.name.size}")
        String newGroupName
) {
}
