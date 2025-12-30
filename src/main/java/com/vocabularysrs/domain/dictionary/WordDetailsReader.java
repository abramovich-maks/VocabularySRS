package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
class WordDetailsReader {

    private final WordDetailsRepository wordDetailsRepository;
    private final WordRetriever wordRetriever;

    Optional<WordHttpDto> getDetails(Long id) {
        WordEntry wordEntry = wordRetriever.findEntityById(id);

        return wordDetailsRepository.findById(id)
                .map(details -> new WordHttpDto(
                        wordEntry.getWord(),
                        details.getPhonetic(),
                        details.getAudioUrl(),
                        new WordHttpDetailsDto(
                                details.getPartOfSpeech(),
                                details.getDefinition(),
                                details.getExample()
                        )
                ));
    }
}
