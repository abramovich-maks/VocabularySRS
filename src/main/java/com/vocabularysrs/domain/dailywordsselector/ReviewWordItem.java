package com.vocabularysrs.domain.dailywordsselector;

import jakarta.persistence.Entity;
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
class ReviewWordItem {

    @Id
    @GeneratedValue(generator = "review_word_item_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "review_word_item_id_seq",
            sequenceName = "review_word_item_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DailyWordReview dailyWordReview;

    private Long wordEntryId;
    private String word;
    private String translate;

    ReviewWordItem(final Long wordEntryId, final String word, final String translate) {
        this.wordEntryId = wordEntryId;
        this.word = word;
        this.translate = translate;
    }
}
