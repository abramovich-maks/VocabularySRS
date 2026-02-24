package com.vocabularysrs.infrastructure.openai.response;


import java.util.List;

public record OpenAiResponse(
        List<OutputResponse> output,
        UsageResponse usage
) {
}


