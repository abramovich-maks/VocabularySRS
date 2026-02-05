package com.vocabularysrs.domain.words;


import com.vocabularysrs.domain.words.dto.AddWordToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordUpdatePartiallyDtoRequest;
import com.vocabularysrs.domain.words.dto.WordWithAutoTranslateDtoRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
public class WordsFacade {

    private final WordAdder wordAdder;
    private final WordDeleter wordDeleter;
    private final WordRetriever wordRetriever;
    private final WordUpdater wordUpdater;
    private final GroupWordAssigner wordAssigner;

    public WordEntryDtoResponse addWord(WordAddDtoRequest dtoRequest) {
        return wordAdder.addWord(dtoRequest);
    }

    public WordEntryDtoResponse addWordWithAutoTranslate(final WordWithAutoTranslateDtoRequest request) {
        return wordAdder.addWordWithAutoTranslate(request);
    }

    public WordEntryDtoResponse deleteWord(Long id) {
        return wordDeleter.deleteById(id);
    }

    public Page<WordDtoResponse> findAllWords(final Pageable pageable) {
        return wordRetriever.findAllByUserId(pageable);
    }

    public WordDtoResponse findById(Long id) {
        return wordRetriever.findById(id);
    }

    public WordEntryUpdateDtoResponse updatePartiallyById(Long id, WordUpdatePartiallyDtoRequest dtoRequest) {
        return wordUpdater.updateById(id, dtoRequest);
    }

    public AddWordsToGroupDtoResponse addWordToGroup(AddWordToGroupDtoRequest request) {
        return wordAssigner.addWordToGroup(request);
    }
}
