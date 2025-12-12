package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordUpdatePartiallyDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordEntryToWordEntryUpdateDtoResponse;

@AllArgsConstructor
@Log4j2
class WordUpdater {

    private final WordRetriever wordRetriever;

    WordEntryUpdateDtoResponse updateById(final Long id, final WordUpdatePartiallyDtoRequest dtoRequest) {
        wordRetriever.existById(id);
        WordEntry wordEntry = wordRetriever.findEntityById(id);
        if (dtoRequest.word() != null) {
            wordEntry.setWord(dtoRequest.word());
            log.info("Entry with id: {} updated word: \"{}\"", wordEntry.getId(), wordEntry.getWord());
        }

        if (dtoRequest.translate() != null) {
            wordEntry.setTranslate(dtoRequest.translate());
            log.info("Entry with id: {} updated translate: \"{}\"", wordEntry.getId(), wordEntry.getTranslate());
        }
        return mapFromWordEntryToWordEntryUpdateDtoResponse(id, wordEntry);
    }
}
