package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

import static com.vocabularysrs.domain.dictionary.WordEntryMapper.mapFromWordEntryToWordDtoResponse;

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

    List<WordDtoResponse> findAllByUserId(Pageable pageable) {
        Long userId = currentUserProvider.getCurrentUserId();
        return wordEntryRepository.findAllByUserId(userId, pageable)
                .stream().map(WordEntryMapper::mapFromWordEntryToWordDtoResponse)
                .collect(Collectors.toList());
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
}