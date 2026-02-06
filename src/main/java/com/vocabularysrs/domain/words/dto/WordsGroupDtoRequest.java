package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WordsGroupDtoRequest(
        Long groupId,
        String groupName,
        List<WordDtoResponse> words

) {
    public int countWord() {
        return words == null ? 0 : words.size();
    }
}
