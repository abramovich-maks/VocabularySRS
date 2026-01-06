package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordDetailsSnapshot;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordDetailsFacade {

    private final WordDetailsRepository repository;
    private final WordEntryReadPort wordEntryReadPort;
    private final WordDetailsFetchable fetchable;
    private final CurrentUserProvider currentUserProvider;

    public WordHttpDto getOrLoad(Long wordId) {
        Long userId = currentUserProvider.getCurrentUserId();

        WordDetailsEntry entry = repository.findByWordIdAndUserId(wordId, userId)
                .orElseGet(() -> loadAndSave(wordId, userId));
        return WordHttpDto.builder().phonetic(entry.getPhonetic()).audioUrl(entry.getAudioUrl()).definition(entry.getDefinition()).example(entry.getExample()).build();
    }


    private WordDetailsEntry loadAndSave(Long wordId, Long userId) {
        WordEntrySnapshot word = wordEntryReadPort.findById(wordId)
                .filter(w -> w.userId().equals(userId))
                .orElseThrow(() -> new IllegalStateException("Word not found: " + wordId));


        WordDetailsSnapshot dto = fetchable.fetch(word.word());

        WordDetailsEntry entry = WordDetailsEntry.builder()
                .wordId(wordId)
                .userId(userId)
                .phonetic(dto.phonetic())
                .audioUrl(dto.audioUrl())
                .partOfSpeech(dto.partOfSpeech())
                .definition(dto.definition())
                .example(dto.example())
                .build();

        repository.save(entry);
        return repository.save(entry);
    }
}
