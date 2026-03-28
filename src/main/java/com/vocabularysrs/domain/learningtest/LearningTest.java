package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.loginandregister.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
class LearningTest {

    @Id
    @GeneratedValue(generator = "learning_task_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "learning_task_id_seq",
            sequenceName = "learning_task_id_seq",
            allocationSize = 10
    )
    private Long id;

    private LocalDate taskDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "learningTest", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setLearningTest(this);
    }


    AnswerResult answerQuestion(Long questionId, String userAnswer) {
        Question question = questions.stream()
                .filter(q -> q.getId().equals(questionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));

        question.answer(userAnswer);

        return question.toResult();
    }

    boolean hasUnansweredQuestions() {
        return questions.stream().anyMatch(q -> !q.isAnswered());
    }
}