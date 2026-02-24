package com.vocabularysrs.infrastructure.openai.response;

public record UsageResponse(
        int input_tokens,
        int output_tokens,
        int total_tokens) {
}
