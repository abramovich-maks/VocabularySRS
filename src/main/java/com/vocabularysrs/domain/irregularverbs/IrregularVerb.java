package com.vocabularysrs.domain.irregularverbs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
class IrregularVerb {

    @Id
    @GeneratedValue(generator = "irregular_verb_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "irregular_verb_id_seq",
            sequenceName = "irregular_verb_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String baseForm;

    private String pastSimple;

    private String pastParticiple;
}
