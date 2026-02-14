package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.shared.Language;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class IrregularVerbFacade {

    private final IrregularVerbRepository repository;
    private final CurrentUserProvider currentUserProvider;

    public List<IrregularVerbDto> findAll() {
        Language language = currentUserProvider.getCurrentUserLanguage();
        return repository.findAllByLanguage(language);
    }
}
