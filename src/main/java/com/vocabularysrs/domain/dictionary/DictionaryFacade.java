package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordUpdatePartiallyDtoRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
public class DictionaryFacade {

    private final WordAdder wordAdder;
    private final WordDeleter wordDeleter;
    private final WordRetriever wordRetriever;
    private final WordUpdater wordUpdater;
    private final WordDetailsReader wordDetailsReader;

    public WordEntryDtoResponse addWord(WordAddDtoRequest dtoRequest) {
        return wordAdder.addWord(dtoRequest);
    }

    public WordEntryDtoResponse deleteWord(Long id) {
        return wordDeleter.deleteById(id);
    }

    public List<WordDtoResponse> findAllWords(final Pageable pageable) {
        return wordRetriever.findAllByUserId(pageable);
    }

    public WordDtoResponse findById(Long id) {
        return wordRetriever.findById(id);
    }

    public WordEntryUpdateDtoResponse updatePartiallyById(Long id, WordUpdatePartiallyDtoRequest dtoRequest) {
        return wordUpdater.updateById(id, dtoRequest);
    }

    public Optional<WordHttpDto> getWordDetails(Long id) {
        return wordDetailsReader.getDetails(id);
    }
}
