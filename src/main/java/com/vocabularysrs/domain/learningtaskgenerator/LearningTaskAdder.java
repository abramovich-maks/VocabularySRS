package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.TRANSLATION_TO_WORD;
import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.WORD_TO_TRANSLATION;

@AllArgsConstructor
class LearningTaskAdder {

    private final LearningTaskRepository learningTaskRepository;
    private final WordEntryReadPort wordEntryReadPort;

    public LearningTask generateForUser(LocalDate taskDate, Long userId) {
        List<WordEntrySnapshot> entries = wordEntryReadPort.findWordEntriesByNextReviewDateAndUserIdLessThanEqual(taskDate, userId);

        LearningTask task = new LearningTask(userId, taskDate, new ArrayList<>());

        for (WordEntrySnapshot word : entries) {
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
        return learningTaskRepository.save(task);
    }

}