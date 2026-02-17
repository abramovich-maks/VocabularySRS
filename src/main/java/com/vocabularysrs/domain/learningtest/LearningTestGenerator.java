package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.LearningTestDto;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.vocabularysrs.domain.learningtest.LearningTestMapper.mapFromLearningTaskToLearningTaskDto;
import static com.vocabularysrs.domain.learningtest.TranslationDirection.TRANSLATION_TO_WORD;
import static com.vocabularysrs.domain.learningtest.TranslationDirection.WORD_TO_TRANSLATION;

@AllArgsConstructor
class LearningTestGenerator {

    private final LearningTestRepository learningTaskRepository;
    private final WordEntryReadPort wordEntryReadPort;

    public LearningTestDto generateDailyTest(LocalDate taskDate, Long userId) {
        List<WordEntrySnapshot> entries = wordEntryReadPort.findWordEntriesByNextReviewDateAndUserIdLessThanEqual(taskDate, userId);

        LearningTest task = new LearningTest(userId, taskDate, new ArrayList<>());

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
        learningTaskRepository.save(task);
        return mapFromLearningTaskToLearningTaskDto(task);
    }

}