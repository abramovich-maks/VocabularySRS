package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@AllArgsConstructor
public class DictionaryFacade {

    private final WordAdder wordAdder;
    private final WordDeleter wordDeleter;
    private final WordRetriever wordRetriever;

    public WordEntryDtoResponse addWord(WordAddDtoRequest dtoRequest) {
        return wordAdder.addWord(dtoRequest);
    }

    public WordEntryDtoResponse deleteWord(Long id) {
        return wordDeleter.deleteById(id);
    }

    public List<WordDtoResponse> findAllWords(final Pageable pageable) {
        return wordRetriever.findAll(pageable);
    }
}
