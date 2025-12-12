package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordAddDtoRequestToWordEntry;
import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordEntryToWordEntryDtoResponse;

@AllArgsConstructor
@Log4j2
class WordAdder {

    private final WordEntryRepository wordRepository;

    WordEntryDtoResponse addWord(final WordAddDtoRequest dtoRequest) {
        if (dtoRequest.word() == null || dtoRequest.translate() == null) {
            log.info("Error: word({}) or translate({}) can't be null", dtoRequest.word(), dtoRequest.translate());
            return new WordEntryDtoResponse(null, null, "Word or translate can't be null");
        }
        WordEntry newWord = mapFromWordAddDtoRequestToWordEntry(dtoRequest);
        WordEntry save = wordRepository.save(newWord);
        log.info("Added new word: {} -> {}", newWord.getWord(), newWord.getTranslate());
        return mapFromWordEntryToWordEntryDtoResponse(save);
    }
}
