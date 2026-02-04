package com.vocabularysrs.domain.words;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "word_group",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"word_id", "group_id"})
        }
)
class WordGroupLink {

    @Id
    @GeneratedValue(generator = "word_group_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "word_group_seq",
            sequenceName = "word_group_seq",
            allocationSize = 50
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    private WordEntry word;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private WordsGroup group;
}
