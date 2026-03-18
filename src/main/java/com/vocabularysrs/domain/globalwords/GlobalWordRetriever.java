package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
class GlobalWordRetriever {

    private final GlobalWordsRepository globalWordsRepository;

    public boolean isExist(String word) {
        Optional<GlobalWord> existing = globalWordsRepository.findByWord(word);
        return existing.isPresent();
    }

    public Optional<GlobalWord> findByWord(GlobalWordRequest request) {
        return globalWordsRepository.findByWord(request.word());
    }
}
