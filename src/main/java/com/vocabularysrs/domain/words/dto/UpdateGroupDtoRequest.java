package com.vocabularysrs.domain.words.dto;

public record UpdateGroupDtoRequest(
        Long groupId,
        String newGroupName
) {
}