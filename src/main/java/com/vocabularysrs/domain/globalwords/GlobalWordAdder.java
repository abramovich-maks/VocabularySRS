package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.globalwords.dto.GlobalWordResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@AllArgsConstructor
@Service
class GlobalWordAdder {

    private final GlobalWordsRepository wordsRepository;
    private final ExampleAsyncGenerator asyncGenerator;
    private final GlobalWordRetriever wordRetriever;


    public GlobalWordResponse addWordToGlobal(GlobalWordRequest request) {
        if (wordRetriever.isExist(request.word())) {
            return GlobalWordResponse.builder().build();
        }

        GlobalWord globalWord = new GlobalWord();
        globalWord.setWord(normalize(request.word()));

        GlobalWord savedGlobalWord = wordsRepository.save(globalWord);

        asyncGenerator.generateAndSaveExamples(request.word(), savedGlobalWord);

        return GlobalWordResponse.builder().globalWordId(savedGlobalWord.getId()).globalWord(savedGlobalWord.getWord()).build();
    }

    private String normalize(final String word) {
        return word.trim().toLowerCase(Locale.ROOT);
    }
}
