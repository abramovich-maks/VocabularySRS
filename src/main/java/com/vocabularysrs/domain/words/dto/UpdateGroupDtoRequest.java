package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record UpdateGroupDtoRequest(
        String newGroupName
) {
}