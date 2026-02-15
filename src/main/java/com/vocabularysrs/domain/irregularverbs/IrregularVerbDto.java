package com.vocabularysrs.domain.irregularverbs;

import java.io.Serializable;

public record IrregularVerbDto(
        String baseForm,
        String baseTranscription,
        String pastSimple,
        String pastTranscription,
        String pastParticiple,
        String pastParticipleTranscription,
        String translation
) implements Serializable {
}
