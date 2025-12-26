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

    public boolean isExistByWord(String word) {
        if (wordEntryRepository.existsByWord(word)) {
            throw new WordAlreadyExistsException(word);
        }
        return false;
    }

    void existById(Long id) {
        if (!wordEntryRepository.existsById(id)) {
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
        WordEntry wordEntry = wordEntryRepository.findById(id)
                .orElseThrow(() -> new WordNotFoundException(id));
        return mapFromWordEntryToWordDtoResponse(wordEntry);
    }

    WordEntry findEntityById(Long id) {
        return wordEntryRepository.findById(id)
                .orElseThrow(() -> new WordNotFoundException(id));
    }
}