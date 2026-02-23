package com.vocabularysrs.domain.openai;

import java.util.List;

public interface ExampleGenerationService {

    List<String> generateExamples(String word);
}
