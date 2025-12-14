package com.vocabularysrs.domain.taskcreator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
class ReviewTask {
    @Id
    @GeneratedValue(generator = "review_task_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "review_task_id_seq",
            sequenceName = "review_task_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate taskDate;

    @OneToMany(mappedBy = "reviewTask", cascade = CascadeType.ALL)
    private List<ReviewTaskItem> items = new ArrayList<>();

    public void addItem(ReviewTaskItem item) {
        this.items.add(item);
        item.setReviewTask(this);
    }
}
