package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.shared.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@RequiredArgsConstructor
public class IrregularVerbFacade {

    private final IrregularVerbRepository repository;

    @Cacheable(value = "irregularVerb", key = "#language")
    public List<IrregularVerbDto> findAll(Language language) {
        return repository.findAllByLanguage(language);
    }
}
