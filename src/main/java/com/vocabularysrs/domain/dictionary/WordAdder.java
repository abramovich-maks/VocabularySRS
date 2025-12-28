package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;

import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordEntryToWordEntryDtoResponse;

@AllArgsConstructor
@Log4j2
class WordAdder {

    private final WordEntryRepository wordRepository;
    private final WordRetriever wordRetriever;
    private final CurrentUserProvider currentUserProvider;

    private final Clock clock;


    WordEntryDtoResponse addWord(final WordAddDtoRequest dtoRequest) {
        LocalDate today = LocalDate.now(clock);

        if (dtoRequest.word() == null) {
            throw InvalidWordException.wordIsNull();
        }
        if (dtoRequest.translate() == null) {
            throw InvalidWordException.translateIsNull();
        }

        String word = WordNormalizer.normalizeWord(dtoRequest.word());
        String translate = WordNormalizer.normalizeTranslate(dtoRequest.translate());

        wordRetriever.assertNotExistsByWord(word);

        WordEntry newWord = WordEntry.builder()
                .word(word)
                .translate(translate)
                .build();

        newWord.initialize(today);
        newWord.setUserId(currentUserProvider.getCurrentUserId());
        WordEntry save = wordRepository.save(newWord);
        log.info("Added new word: {} -> {}", newWord.getWord(), newWord.getTranslate());
        return mapFromWordEntryToWordEntryDtoResponse(save);
    }
}
