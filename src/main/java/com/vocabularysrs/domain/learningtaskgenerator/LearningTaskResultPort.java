package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;
import java.util.List;

public interface LearningTaskResultPort {

    List<AnswerResult> getResultsForTask(LocalDate date, Long userId);
}
