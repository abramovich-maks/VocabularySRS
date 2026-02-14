package com.vocabularysrs.domain.irregularverbs;

public record IrregularVerbDto(
        String baseForm,
        String baseTranscription,
        String pastSimple,
        String pastTranscription,
        String pastParticiple,
        String pastParticipleTranscription,
        String translation
) {
}
