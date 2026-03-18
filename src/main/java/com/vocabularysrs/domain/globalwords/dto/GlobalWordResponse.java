package com.vocabularysrs.domain.globalwords.dto;

import lombok.Builder;

@Builder
public record GlobalWordResponse(
        Long globalWordId,
        String globalWord
) {
}
