package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AssignWordsToGroupRequest(
        List<Long> wordIds

) {
}
