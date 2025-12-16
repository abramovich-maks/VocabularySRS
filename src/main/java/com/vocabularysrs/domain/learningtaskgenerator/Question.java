package com.vocabularysrs.domain.learningtaskgenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
class Question {
    @Id
    @GeneratedValue(generator = "question_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "question_id_seq",
            sequenceName = "question_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String prompt;

    @Enumerated(EnumType.STRING)
    private TranslationDirection direction;

    @ManyToOne(fetch = FetchType.LAZY)
    private LearningTask task;

    Question(final String prompt, final TranslationDirection direction) {
        this.prompt = prompt;
        this.direction = direction;
    }
}

