package com.vocabularysrs.domain.words;


import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordUpdatePartiallyDtoRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@AllArgsConstructor
public class WordsFacade {

    private final WordAdder wordAdder;
    private final WordDeleter wordDeleter;
    private final WordRetriever wordRetriever;
    private final WordUpdater wordUpdater;

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

//    public Optional<WordHttpDto> getWordDetails(Long id) {
//        return wordDetailsReader.getDetails(id);
//    }
}
