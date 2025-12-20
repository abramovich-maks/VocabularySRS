package com.vocabularysrs.domain.dictionary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
class WordEntry {
    @Id
    @GeneratedValue(generator = "word_entry_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "word_entry_id_seq",
            sequenceName = "word_entry_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String translate;

    @Column(nullable = false)
    private LocalDate dateAdded;

    @Enumerated(EnumType.STRING)
    private RepetitionInterval currentInterval = RepetitionInterval.INTERVAL_1_DAY;

    private LocalDate nextReviewDate;

    void initialize(LocalDate today) {
        this.dateAdded = today;
        this.currentInterval = RepetitionInterval.INTERVAL_1_DAY;
        this.nextReviewDate = today.plusDays(currentInterval.getDays());
    }

    void applyReviewResult(boolean correct, RepetitionIntervalCalculator calculator, LocalDate today) {
        this.currentInterval = correct ? calculator.next(this.currentInterval) : calculator.back(this.currentInterval);
        this.nextReviewDate = today.plusDays(this.currentInterval.getDays());
    }
}
