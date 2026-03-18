package com.vocabularysrs.infrastructure.openai.request;

public record ContentRequest(
        String type,
        String text
) {
}
