package com.vocabularysrs.infrastructure.dictionary.http.dto;

import java.util.List;

public record DictionaryApiResponse(
        String word,
        String phonetic,
        List<PhoneticDto> phonetics,
        List<MeaningDto> meanings
) {
}