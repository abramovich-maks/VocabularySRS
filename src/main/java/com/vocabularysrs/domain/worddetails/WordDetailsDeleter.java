package com.vocabularysrs.domain.worddetails;

public interface WordDetailsDeleter {
    void deleteByWordId(Long wordId, Long userId);
}
