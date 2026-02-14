package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.shared.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface IrregularVerbRepository extends Repository<IrregularVerb, Long> {

    @Query("""
                SELECT new com.vocabularysrs.domain.irregularverbs.IrregularVerbDto(
                    v.baseForm,
                    v.baseTranscription,
                    v.pastSimple,
                    v.pastTranscription,
                    v.pastParticiple,
                    v.pastParticipleTranscription,
                    t.translation
                )
                FROM IrregularVerb v
                JOIN IrregularVerbTranslation t ON t.verb = v
                WHERE t.language = :language
                ORDER BY v.baseForm
            """)
    List<IrregularVerbDto> findAllByLanguage(Language language);
}
