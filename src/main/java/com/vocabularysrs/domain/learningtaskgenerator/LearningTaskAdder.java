package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;
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

    private final LearningTaskRepository learningTaskRepository;
    private final WordEntryReadPort wordEntryReadPort;

    public List<LearningTask> generateTasks(LocalDate taskDate) {

        List<WordEntrySnapshot> entries =
                wordEntryReadPort.findWordEntriesByNextReviewDateLessThanEqual(taskDate);

        Map<Long, List<WordEntrySnapshot>> byUser =
                entries.stream()
                        .collect(Collectors.groupingBy(WordEntrySnapshot::userId));

        List<LearningTask> result = new ArrayList<>();

        for (var entry : byUser.entrySet()) {
            Long userId = entry.getKey();

            LearningTask task = new LearningTask(userId, taskDate, new ArrayList<>());

            for (WordEntrySnapshot word : entry.getValue()) {
                task.addQuestion(new Question(
                        word.id(),
                        word.word(),
                        WORD_TO_TRANSLATION,
                        word.translate()
                ));
                task.addQuestion(new Question(
                        word.id(),
                        word.translate(),
                        TRANSLATION_TO_WORD,
                        word.word()
                ));
            }

            result.add(learningTaskRepository.save(task));
        }

        return result;
    }
}