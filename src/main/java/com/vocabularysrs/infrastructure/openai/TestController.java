package com.vocabularysrs.infrastructure.openai;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class TestController {

    private final OpenAiExampleGenerationService service;

    @PostMapping("/test/{word}")
    public List<String> f(@PathVariable String word) {
        return service.generateExamples(word);
    }
}
