package com.vocabularysrs.infrastructure.translation.http;

public record TranslateRequest(
        String q,
        String source,
        String target,
        String format,
        int alternatives
) {
}