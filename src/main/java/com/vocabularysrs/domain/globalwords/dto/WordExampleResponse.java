package com.vocabularysrs.domain.globalwords.dto;

import lombok.Builder;

@Builder
public record WordExampleResponse(
        Long id,
        String example
) {
}
