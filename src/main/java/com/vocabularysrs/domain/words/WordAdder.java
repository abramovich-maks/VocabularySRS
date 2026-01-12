package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.translation.TranslationResult;
import com.vocabularysrs.domain.translation.WordTranslator;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordWithAutoTranslateDtoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;

import static com.vocabularysrs.domain.words.WordEntryMapper.mapFromWordEntryToWordEntryDtoResponse;

@AllArgsConstructor
@Log4j2
class WordAdder {

    private final WordEntryRepository wordRepository;
    private final WordRetriever wordRetriever;
    private final CurrentUserProvider currentUserProvider;
    private final WordTranslator wordTranslator;

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

    WordEntryDtoResponse addWordWithAutoTranslate(final WordWithAutoTranslateDtoRequest request) {
        LocalDate today = LocalDate.now(clock);

        if (request.word() == null) {
            throw InvalidWordException.wordIsNull();
        }

        String word = WordNormalizer.normalizeWord(request.word());
        wordRetriever.assertNotExistsByWord(word);
        TranslationResult translation = wordTranslator.translate(word);

        if (!translation.isSuccessful()) {
            throw InvalidWordException.translationFailed(word);
        }

        WordEntry newWord = WordEntry.builder()
                .word(word)
                .translate(translation.translatedText())
                .build();

        newWord.initialize(today);
        newWord.setUserId(currentUserProvider.getCurrentUserId());

        WordEntry saved = wordRepository.save(newWord);

        log.info("Added new word (auto-translate): {} -> {}", saved.getWord(), saved.getTranslate());

        return mapFromWordEntryToWordEntryDtoResponse(saved);
    }
}
