package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.globalwords.dto.WordExampleListResponse;
import com.vocabularysrs.domain.globalwords.dto.WordExampleResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class WordExampleRetriever {

    private final ExampleRepository exampleRepository;
    private final GlobalWordRetriever globalWordRetriever;

    public WordExampleListResponse findExampleByWord(GlobalWordRequest request) {
        GlobalWord globalWord = globalWordRetriever.findByWord(request)
                .orElseThrow(() -> new GlobalWordNotFoundException(request.word()));
        List<WordExample> examples = exampleRepository.findByWord(globalWord);
        List<WordExampleResponse> wordExamplesResponses = examples.stream().map(example -> WordExampleResponse.builder().id(example.getId()).example(example.getExample()).build()).toList();
        return WordExampleListResponse.builder().example(wordExamplesResponses).build();
    }
}
