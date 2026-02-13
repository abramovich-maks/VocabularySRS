package com.vocabularysrs.domain.irregularverbs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Entity
class IrregularVerb {

    @Id
    @GeneratedValue(generator = "irregular_verb_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "irregular_verb_id_seq",
            sequenceName = "irregular_verb_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String baseForm;

    @Column(nullable = false)
    private String baseTranscription;

    @Column(nullable = false)
    private String pastSimple;

    @Column(nullable = false)
    private String pastTranscription;

    @Column(nullable = false)
    private String pastParticiple;

    @Column(nullable = false)
    private String pastParticipleTranscription;
}
