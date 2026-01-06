package com.vocabularysrs.domain.worddetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;

    private String phonetic;
    private String audioUrl;

    private String partOfSpeech;

    @Column(length = 1000)
    private String definition;

    @Column(length = 1000)
    private String example;
}

