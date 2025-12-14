package com.vocabularysrs.domain.taskcreator;

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
class ReviewTaskItem {

    @Id
    @GeneratedValue(generator = "review_task_item_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "review_task_item_id_seq",
            sequenceName = "review_task_item_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReviewTask reviewTask;

    private Long wordEntryId;

    private int attempts;

    public ReviewTaskItem(Long wordEntryId) {
        this.wordEntryId = wordEntryId;
        this.attempts = 0;
    }
}
