package com.vocabularysrs.domain.globalwords.dto;

import lombok.Builder;

@Builder
public record GlobalWordRequest(
        String word
) {
}
