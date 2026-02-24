package com.vocabularysrs.infrastructure.openai.request;

import java.util.List;

public record OpenAiRequest(
        String model,
        List<InputRequest> input,
        ReasoningRequest reasoning,
        boolean store
) {
}