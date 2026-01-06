package com.vocabularysrs.domain.worddetails;

import jakarta.persistence.Column;
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
class WordDetailsEntry {
    @Id
    @GeneratedValue(generator = "word_details_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "word_details_id_seq",
            sequenceName = "word_details_id_seq",
            allocationSize = 1
    )
    private Long id;

    private Long wordId;
    private Long userId;

    private String phonetic;
    private String audioUrl;

    private String partOfSpeech;

    @Column(length = 1000)
    private String definition;

    @Column(length = 1000)
    private String example;
}

