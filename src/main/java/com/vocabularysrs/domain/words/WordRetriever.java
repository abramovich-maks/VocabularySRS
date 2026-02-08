package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.vocabularysrs.domain.words.WordEntryMapper.mapFromListWordEntryToWordsDtoResponse;
import static com.vocabularysrs.domain.words.WordEntryMapper.mapFromWordEntryToWordDtoResponse;

@AllArgsConstructor
class WordRetriever {

    private final WordEntryRepository wordEntryRepository;
    private final CurrentUserProvider currentUserProvider;

    void assertNotExistsByWord(String word) {
        Long userId = currentUserProvider.getCurrentUserId();
        if (wordEntryRepository.existsByWordAndUserId(word, userId)) {
            throw new WordAlreadyExistsException(word);
        }
    }

    void assertExistsById(Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        if (!wordEntryRepository.existsByIdAndUserId(id, userId)) {
            throw new WordNotFoundException(id);
        }
    }

    Page<WordDtoResponse> findAllByUserId(Pageable pageable) {
        Long userId = currentUserProvider.getCurrentUserId();
        return wordEntryRepository.findAllByUserId(userId, pageable)
                .map(WordEntryMapper::mapFromWordEntryToWordDtoResponse);
    }

    WordDtoResponse findById(Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        WordEntry wordEntry = wordEntryRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new WordNotFoundException(id));
        return mapFromWordEntryToWordDtoResponse(wordEntry);
    }

    WordEntry findEntityById(Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        return wordEntryRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new WordNotFoundException(id));
    }

    public WordsDtoResponse findAvailableWords(Long groupId) {
        Long userId = currentUserProvider.getCurrentUserId();
        List<WordEntry> availableWords = wordEntryRepository.findAvailableWords(userId, groupId);
        return mapFromListWordEntryToWordsDtoResponse(availableWords);
    }
}