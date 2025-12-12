package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
class WordRetriever {

    private final WordEntryRepository wordEntryRepository;

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

    List<WordDtoResponse> findAll(final Pageable pageable) {
        return wordEntryRepository.findAll(pageable)
                .stream().map(word -> WordDtoResponse.builder()
                        .id(word.getId())
                        .word(word.getWord())
                        .translate(word.getTranslate())
                        .build())
                .collect(Collectors.toList());
    }
}