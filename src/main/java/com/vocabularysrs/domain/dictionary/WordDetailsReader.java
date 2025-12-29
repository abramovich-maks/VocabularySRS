package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class WordDetailsReader {

    private final WordDetailsRepository wordDetailsRepository;
    private final WordRetriever wordRetriever;

    WordHttpDto getDetails(Long id) {
        WordEntry wordEntry = wordRetriever.findEntityById(id);

        WordDetailsEntry details = wordDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Word details not found"));

        return new WordHttpDto(
                wordEntry.getWord(),
                details.getPhonetic(),
                details.getAudioUrl(),
                new WordHttpDetailsDto(
                        details.getPartOfSpeech(),
                        details.getDefinition(),
                        details.getExample()
                )
        );
    }
}
