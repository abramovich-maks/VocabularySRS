package com.vocabularysrs.infrastructure.dictionary.http;

import com.vocabularysrs.domain.words.WordDetailsSnapshot;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DefinitionDto;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DictionaryApiResponse;
import com.vocabularysrs.infrastructure.dictionary.http.dto.MeaningDto;
import com.vocabularysrs.infrastructure.dictionary.http.dto.PhoneticDto;

class DictionaryApiResponseMapper {

    public static WordDetailsSnapshot mapToWordHttpDto(DictionaryApiResponse entry) {

        MeaningDto meaning = entry.meanings().stream()
                .filter(m -> "noun".equals(m.partOfSpeech()))
                .findFirst()
                .orElse(entry.meanings().get(0));

        DefinitionDto definition = meaning.definitions().get(0);

        String phonetic = entry.phonetic();
        if (phonetic == null || phonetic.isBlank()) {
            phonetic = entry.phonetics().stream()
                    .map(PhoneticDto::text)
                    .filter(t -> t != null && !t.isBlank())
                    .findFirst()
                    .orElse(null);
        }

        String audioUrl = entry.phonetics().stream()
                .map(PhoneticDto::audio)
                .filter(a -> a != null && !a.isBlank())
                .findFirst()
                .orElse(null);

        return new WordDetailsSnapshot(
                phonetic,
                audioUrl,
                meaning.partOfSpeech(),
                definition.definition(),
                definition.example()
        );
    }
}