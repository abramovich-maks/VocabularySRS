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
            allocationSize = 50
    )
    private Long id;

    private Long wordEntryId;

    private String prompt;

    @Enumerated(EnumType.STRING)
    private TranslationDirection direction;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private LearningTask learningTask;

    Question(final Long wordEntryId, final String prompt, final TranslationDirection direction, String answer) {
        this.wordEntryId = wordEntryId;
        this.prompt = prompt;
        this.direction = direction;
        this.answer = answer;
    }
}

