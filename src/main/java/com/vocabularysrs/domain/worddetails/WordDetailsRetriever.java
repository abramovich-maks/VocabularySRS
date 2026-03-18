package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.globalwords.GlobalWordFacade;
import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.globalwords.dto.WordExampleListResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.translation.TranslationAlternativeService;
import com.vocabularysrs.domain.translation.TranslationAlternatives;
import com.vocabularysrs.domain.worddetails.dto.WordHttpDto;
import com.vocabularysrs.domain.words.WordDetailsSnapshot;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class WordDetailsRetriever {
    private final WordDetailsRepository repository;
    private final WordEntryReadPort wordEntryReadPort;
    private final WordDetailsFetchable fetchable;
    private final CurrentUserProvider currentUserProvider;
    private final TranslationAlternativeService translationAlternativeService;

    private final GlobalWordFacade globalWordFacade;


    public WordHttpDto getOrLoad(Long wordId) {
        Long userId = currentUserProvider.getCurrentUserId();
        WordEntrySnapshot word = wordEntryReadPort.findById(wordId)
                .orElseThrow(() -> new IllegalStateException("Word not found: " + wordId));
        WordExampleListResponse exampleByWord = globalWordFacade.findExampleByWord(GlobalWordRequest.builder().word(word.word()).build());


        WordDetailsEntry entry = repository.findByWordIdAndUserId(wordId, userId)
                .orElseGet(() -> loadAndSave(wordId, userId));
        List<String> alternativeTranslations = entry.getAlternatives().stream().map(WordDetailsAlternativeTranslation::getAlternativeTranslate).toList();
        return WordHttpDto.builder().phonetic(entry.getPhonetic()).audioUrl(entry.getAudioUrl()).examples(exampleByWord.example()).alternatives(alternativeTranslations).build();
    }


    private WordDetailsEntry loadAndSave(Long wordId, Long userId) {
        WordEntrySnapshot word = wordEntryReadPort.findById(wordId)
                .filter(w -> w.userId().equals(userId))
                .orElseThrow(() -> new IllegalStateException("Word not found: " + wordId));

        Language language = currentUserProvider.getCurrentUserLanguage();

        WordDetailsSnapshot dto = fetchable.fetch(word.word());
        TranslationAlternatives alternatives = translationAlternativeService.getAlternatives(word.word(), language.getLanguage());
        WordDetailsEntry wordDetailsEntry = WordDetailsEntry.builder()
                .wordId(wordId)
                .userId(userId)
                .phonetic(dto.phonetic())
                .audioUrl(dto.audioUrl())
                .build();

        alternatives.values().forEach(translate ->
                wordDetailsEntry.addAlternative(
                        new WordDetailsAlternativeTranslation(wordDetailsEntry, translate)
                ));
        return repository.save(wordDetailsEntry);
    }
}
