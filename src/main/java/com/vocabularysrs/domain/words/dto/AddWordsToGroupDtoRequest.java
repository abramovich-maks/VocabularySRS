package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AddWordsToGroupDtoRequest(
        List<Long> wordIds
) {
}
