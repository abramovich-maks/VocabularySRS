package com.vocabularysrs.infrastructure.openai.response;

public record ContentResponse(
        String type,
        String text
) {
}
