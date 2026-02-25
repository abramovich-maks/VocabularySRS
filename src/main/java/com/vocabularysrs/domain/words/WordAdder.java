package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.globalwords.GlobalWordFacade;
import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.translation.TranslationResult;
import com.vocabularysrs.domain.translation.WordTranslator;
import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
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
    private final WordDetailsFetchable wordFetchable;
    private final WordsGroupRetriever groupRetriever;
    private final GroupWordAssigner groupWordAssigner;
    private final GlobalWordFacade globalWordFacade;

    private final Clock clock;


    WordEntryDtoResponse addWord(final WordAddDtoRequest request) {
        LocalDate today = LocalDate.now(clock);

        if (request.word() == null) {
            throw InvalidWordException.wordIsNull();
        }
        if (request.translate() == null) {
            throw InvalidWordException.translateIsNull();
        }

        String word = WordNormalizer.normalizeWord(request.word());
        String translate = WordNormalizer.normalizeTranslate(request.translate());

        wordRetriever.assertNotExistsByWord(word);

        WordEntry newWord = WordEntry.builder()
                .word(word)
                .translate(translate)
                .build();

        WordsGroup group = null;
        if (request.groupId() != null) {
            group = groupRetriever.findEntityById(request.groupId());
        }
        return saveAndAssignWord(newWord, today, group);
    }

    WordEntryDtoResponse addWordWithAutoTranslate(final WordWithAutoTranslateDtoRequest request) {
        LocalDate today = LocalDate.now(clock);

        if (request.word() == null) {
            throw InvalidWordException.wordIsNull();
        }

        String word = WordNormalizer.normalizeWord(request.word());
        wordRetriever.assertNotExistsByWord(word);
        TranslationResult translation = wordTranslator.translate(word);

        wordFetchable.fetch(word);

        WordEntry newWord = WordEntry.builder()
                .word(word)
                .translate(translation.translatedText())
                .build();

        WordsGroup group = null;
        if (request.groupId() != null) {
            group = groupRetriever.findEntityById(request.groupId());
        }
        WordEntryDtoResponse saved = saveAndAssignWord(newWord, today, group);
        globalWordFacade.addWordToGlobal(GlobalWordRequest.builder().word(saved.word()).build());
        return saved;
    }

    private WordEntryDtoResponse saveAndAssignWord(final WordEntry newWord, final LocalDate today, final WordsGroup group) {
        newWord.initialize(today);
        newWord.setUserId(currentUserProvider.getCurrentUserId());

        WordEntry saved = wordRepository.save(newWord);

        if (group != null) {
            groupWordAssigner.addWordToGroup(group.getId(), saved.getId());
        }

        log.info("Added new word: {} -> {}", newWord.getWord(), newWord.getTranslate());
        return mapFromWordEntryToWordEntryDtoResponse(saved);
    }
}
