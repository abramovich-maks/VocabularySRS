package com.vocabularysrs.domain.learningtaskgenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
class LearningTask {

    @Id
    @GeneratedValue(generator = "learning_task_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "learning_task_id_seq",
            sequenceName = "learning_task_id_seq",
            allocationSize = 10
    )
    private Long id;

    private LocalDate taskDate;

    private Long userId;

    @OneToMany(mappedBy = "learningTask", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private LearningTaskStatus status = LearningTaskStatus.PENDING;

    LearningTask(final Long userId, final LocalDate taskDate, final List<Question> questions) {
        this.userId = userId;
        this.taskDate = taskDate;
        this.questions = questions;
    }

    public void markCompleted() {
        this.status = LearningTaskStatus.COMPLETED;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setLearningTask(this);
    }
}
