package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static java.lang.String.format;

@Log4j2
@Transactional
@AllArgsConstructor
class WordDeleter {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;

    WordEntryDtoResponse deleteById(final Long id) {
        wordRetriever.assertExistsById(id);
        wordEntryRepository.deleteById(id);
        log.info("Deleted word by id: {}", id);
        return WordEntryDtoResponse.builder()
                .message(format("Deleted word by id: %s", id))
                .build();
    }
}
