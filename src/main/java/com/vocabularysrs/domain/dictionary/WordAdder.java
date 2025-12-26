package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordAddDtoRequestToWordEntry;
import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordEntryToWordEntryDtoResponse;

@AllArgsConstructor
@Log4j2
class WordAdder {

    private final WordEntryRepository wordRepository;
    private final WordRetriever wordRetriever;
    private final CurrentUserProvider currentUserProvider;

    private final AdjustableClock clock;


    WordEntryDtoResponse addWord(final WordAddDtoRequest dtoRequest) {
        LocalDate today = clock.today();

        if (dtoRequest.word() == null || dtoRequest.translate() == null) {
            log.info("Error: word({}) or translate({}) can't be null", dtoRequest.word(), dtoRequest.translate());
            return new WordEntryDtoResponse(null, null, "Word or translate can't be null");
        }
        wordRetriever.isExistByWord(dtoRequest.word());
        WordEntry newWord = mapFromWordAddDtoRequestToWordEntry(dtoRequest);
        newWord.initialize(today);
        newWord.setUserId(currentUserProvider.getCurrentUserId());
        WordEntry save = wordRepository.save(newWord);
        log.info("Added new word: {} -> {}", newWord.getWord(), newWord.getTranslate());
        return mapFromWordEntryToWordEntryDtoResponse(save);
    }
}
