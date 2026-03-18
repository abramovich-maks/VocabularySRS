package com.vocabularysrs.infrastructure.openai.request;

import java.util.List;

public record InputRequest(
        String role,
        List<ContentRequest> content
) {
}

