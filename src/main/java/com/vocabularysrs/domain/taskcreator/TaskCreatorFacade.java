package com.vocabularysrs.domain.taskcreator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Log4j2
public class TaskCreatorFacade {

    private final WordEntryReadPort wordEntryReadPort;
    private final ReviewTaskRepository reviewTaskRepository;

    public ReviewTask createDailyTask() {
        LocalDate today = LocalDate.now();

        reviewTaskRepository.findByTaskDate(today).ifPresent(existing -> {
            throw new TaskAlreadyExist(today);
        });

        List<WordEntrySnapshot> wordsForReview = wordEntryReadPort.findWordsForReview(today);

        ReviewTask reviewTask = new ReviewTask();
        reviewTask.setTaskDate(today);

        for (WordEntrySnapshot word : wordsForReview) {
            ReviewTaskItem item = new ReviewTaskItem(word.id());
            reviewTask.addItem(item);
        }
        log.info("Created ReviewTask for {} items", reviewTask.getItems().size());
        return reviewTaskRepository.save(reviewTask);
    }
}