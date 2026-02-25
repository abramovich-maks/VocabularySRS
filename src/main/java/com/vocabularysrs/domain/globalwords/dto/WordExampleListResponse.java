package com.vocabularysrs.domain.globalwords.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WordExampleListResponse(
        List<WordExampleResponse> example
) {
}
