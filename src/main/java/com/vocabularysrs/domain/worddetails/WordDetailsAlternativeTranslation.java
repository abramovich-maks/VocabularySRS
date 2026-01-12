package com.vocabularysrs.domain.worddetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
class WordDetailsAlternativeTranslation {

    @Id
    @GeneratedValue(generator = "alternative_translate_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "alternative_translate_id_seq",
            sequenceName = "alternative_translate_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "word_details_id", nullable = false)
    private WordDetailsEntry wordDetailsEntry;

    @Column(nullable = false)
    private String alternativeTranslate;

    WordDetailsAlternativeTranslation(WordDetailsEntry wordDetailsEntry, String alternativeTranslate) {
        this.wordDetailsEntry = wordDetailsEntry;
        this.alternativeTranslate = alternativeTranslate;
    }
}