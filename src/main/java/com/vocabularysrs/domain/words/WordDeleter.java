package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.worddetails.WordDetailsDeleter;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
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
    private final WordDetailsDeleter wordDetailsDeleter;
    private final WordGroupLinkRepository linkRepository;


    WordEntryDtoResponse deleteById(final Long id) {
        WordEntry word = wordRetriever.findEntityById(id);
        linkRepository.deleteByWord_Id(id);
        wordEntryRepository.delete(word);
        wordDetailsDeleter.deleteByWordId(id, word.getUserId());

        log.info("Deleted word by id: {}, userId: {}", id, word.getUserId());
        return WordEntryDtoResponse.builder()
                .message(format("Deleted word by id: %s", id))
                .build();
    }
}
