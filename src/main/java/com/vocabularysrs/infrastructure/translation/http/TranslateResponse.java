package com.vocabularysrs.infrastructure.translation.http;

import java.util.List;

public record TranslateResponse(
        String translatedText,
        List<String> alternatives
) {
}