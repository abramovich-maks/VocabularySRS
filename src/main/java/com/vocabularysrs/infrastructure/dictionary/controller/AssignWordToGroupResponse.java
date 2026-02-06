package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import lombok.Builder;

@Builder
public record AssignWordToGroupResponse(
        String groupName,
        WordDtoControllerResponse word
) {
}
