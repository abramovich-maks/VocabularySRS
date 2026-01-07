package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordUpdatePartiallyDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.vocabularysrs.domain.words.WordEntryMapper.mapFromWordEntryToWordEntryUpdateDtoResponse;

@AllArgsConstructor
@Log4j2
class WordUpdater {

    private final WordRetriever wordRetriever;

    WordEntryUpdateDtoResponse updateById(final Long id, final WordUpdatePartiallyDtoRequest dtoRequest) {
        wordRetriever.assertExistsById(id);
        WordEntry wordEntry = wordRetriever.findEntityById(id);
        if (dtoRequest.word() != null) {
            String normalizedWord = WordNormalizer.normalizeWord(dtoRequest.word());
            if (!normalizedWord.equals(wordEntry.getWord())) {
                wordRetriever.assertNotExistsByWord(normalizedWord);
            }
            wordEntry.setWord(normalizedWord);
            log.info("Entry with id: {} updated word: \"{}\"", wordEntry.getId(), normalizedWord);
        }

        if (dtoRequest.translate() != null) {
            String normalizedTranslate =
                    WordNormalizer.normalizeTranslate(dtoRequest.translate());

            wordEntry.setTranslate(normalizedTranslate);
            log.info("Entry with id: {} updated translate: \"{}\"", wordEntry.getId(), normalizedTranslate);
        }
        return mapFromWordEntryToWordEntryUpdateDtoResponse(id, wordEntry);
    }
}
