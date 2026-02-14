package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.shared.Language;

import java.util.List;

class InMemoryIrregularVerbTestImpl implements IrregularVerbRepository{


    @Override
    public List<IrregularVerbDto> findAllByLanguage(final Language language) {
        return List.of();
    }
}
