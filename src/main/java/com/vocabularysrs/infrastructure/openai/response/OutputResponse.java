package com.vocabularysrs.infrastructure.openai.response;

import java.util.List;

public record OutputResponse(
        String type,
        List<ContentResponse> content
) {
}
