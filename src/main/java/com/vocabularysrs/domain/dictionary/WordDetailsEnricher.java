package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
class WordDetailsEnricher {

    private final WordDetailsFetchable wordDetailsFetchable;
    private final WordDetailsRepository wordDetailsRepository;
    private final WordRetriever wordRetriever;

    void enrich(Long id) {
        WordEntry wordEntry = wordRetriever.findEntityById(id);
        try {
            WordHttpDto httpDto = wordDetailsFetchable.details(wordEntry.getWord());

            WordDetailsEntry details = WordDetailsEntry.builder()
                    .wordEntry(wordEntry)
                    .phonetic(httpDto.phonetic())
                    .audioUrl(httpDto.audioUrl())
                    .partOfSpeech(httpDto.details().partOfSpeech())
                    .definition(httpDto.details().definition())
                    .example(httpDto.details().example())
                    .build();

            wordDetailsRepository.save(details);

        } catch (Exception e) {
            log.warn("Failed to enrich word [{}] for user [{}]", wordEntry.getWord(), wordEntry.getUserId(), e);
        }
    }
}
