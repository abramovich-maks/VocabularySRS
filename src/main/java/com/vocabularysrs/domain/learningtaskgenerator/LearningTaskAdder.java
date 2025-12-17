package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.dailywordsselector.DailyWordReadPort;
import com.vocabularysrs.domain.dailywordsselector.DailyWordSnapshot;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.TRANSLATION_TO_WORD;
import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.WORD_TO_TRANSLATION;

@AllArgsConstructor
class LearningTaskAdder {

    private final DailyWordReadPort dailyWordReadPort;
    private final LearningTaskRepository learningTaskRepository;

    public List<LearningTask> generateTasks() {
        LocalDate today = LocalDate.now();
        List<DailyWordSnapshot> snapshots =
                dailyWordReadPort.findDailyWordReviewByTaskDate(today);

        Map<Long, List<DailyWordSnapshot>> byUser =
                snapshots.stream()
                        .collect(Collectors.groupingBy(DailyWordSnapshot::userId));

        List<LearningTask> result = new ArrayList<>();

        for (var entry : byUser.entrySet()) {
            Long userId = entry.getKey();

            LearningTask task = new LearningTask(userId, today, new ArrayList<>());

            for (DailyWordSnapshot snapshot : entry.getValue()) {
                snapshot.items().forEach(item -> {
                    task.addQuestion(new Question(item.word(), WORD_TO_TRANSLATION));
                    task.addQuestion(new Question(item.translation(), TRANSLATION_TO_WORD));
                });
            }
            result.add(learningTaskRepository.save(task));
        }

        return result;
    }
}