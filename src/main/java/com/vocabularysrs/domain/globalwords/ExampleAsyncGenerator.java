package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.openai.ExampleGenerationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class ExampleAsyncGenerator {

    private final ExampleGenerationService exampleGenerationService;
    private final ExampleRepository exampleRepository;

    @Async
    public void generateAndSaveExamples(String word, GlobalWord globalWord) {
        try {
            List<String> examples = exampleGenerationService.generateExamples(word);
            examples.stream()
                    .map(text -> new WordExample(null, text, globalWord))
                    .forEach(exampleRepository::save);
        } catch (Exception e) {
            log.error("Failed async example generation", e);
        }
    }
}
