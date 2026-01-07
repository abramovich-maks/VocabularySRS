package com.vocabularysrs.domain.worddetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class WordDetailsDeleterImpl implements WordDetailsDeleter {

    private final WordDetailsRepository wordDetailsRepository;

    @Override
    public void deleteByWordId(final Long wordId, final Long userId) {
        wordDetailsRepository.deleteByWordIdAndUserId(wordId, userId);
    }
}
