package com.vocabularysrs.domain.irregularverbs;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
class IrregularVerbTranslation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "irregular_verb_translation_id_seq"
    )
    @SequenceGenerator(
            name = "irregular_verb_translation_id_seq",
            sequenceName = "irregular_verb_translation_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String languageCode;

    private String translation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verb_id", nullable = false)
    private IrregularVerb verb;
}

