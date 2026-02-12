package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.shared.Language;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"verb_id", "language"}
        )
)
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(nullable = false)
    private String translation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verb_id", nullable = false)
    private IrregularVerb verb;
}

