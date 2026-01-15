package com.vocabularysrs.infrastructure.dictionary.http;

import com.vocabularysrs.domain.words.WordDetailsSnapshot;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DefinitionDto;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DictionaryApiResponse;
import com.vocabularysrs.infrastructure.dictionary.http.dto.MeaningDto;
import com.vocabularysrs.infrastructure.dictionary.http.dto.PhoneticDto;

import java.util.List;

class DictionaryApiResponseMapper {

    public static WordDetailsSnapshot mapToWordHttpDto(DictionaryApiResponse entry) {

        PhoneticDto phoneticDto = resolvePhonetic(entry.phonetics());
        DefinitionDto definitionDto = resolveDefinition(entry.meanings());

        return new WordDetailsSnapshot(
                phoneticDto.text(),
                phoneticDto.audio(),
                definitionDto.definition(),
                definitionDto.example()
        );
    }

    private static PhoneticDto resolvePhonetic(List<PhoneticDto> phonetics) {
        if (phonetics == null || phonetics.isEmpty()) {
            return null;
        }

        return phonetics.stream()
                .filter(word -> isNotBlank(word.audio()))
                .filter(word -> word.audio().contains("-us"))
                .findFirst()
                .or(() -> phonetics.stream()
                        .filter(word -> isNotBlank(word.audio()))
                        .findFirst())
                .or(() -> phonetics.stream()
                        .filter(word -> isNotBlank(word.text()))
                        .findFirst())
                .orElse(null);
    }

    private static DefinitionDto resolveDefinition(List<MeaningDto> meanings) {
        if (meanings == null || meanings.isEmpty()) {
            return null;
        }

        MeaningDto meaning = meanings.get(0);
        if (meaning.definitions() == null || meaning.definitions().isEmpty()) {
            return null;
        }

        return meaning.definitions().get(0);
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}