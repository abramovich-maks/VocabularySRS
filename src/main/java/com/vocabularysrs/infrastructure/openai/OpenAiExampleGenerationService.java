package com.vocabularysrs.infrastructure.openai;

import com.vocabularysrs.domain.openai.ExampleGenerationService;

import java.util.List;

class OpenAiExampleGenerationService implements ExampleGenerationService {

    @Override
    public List<String> generateExamples(final String word) {
        return List.of();
    }
}
