package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.UpdateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class WordsGroupFacade {

    private final WordsGroupAdder groupAdder;
    private final WordsGroupDeleter groupDeleter;
    private final WordsGroupRetriever groupRetriever;
    private final WordsGroupUpdater groupUpdater;
    private final GroupWordAssigner wordAssigner;


    public CreateGroupDtoResponse createWordsGroup(CreateGroupDtoRequest dtoRequest) {
        return groupAdder.createWordsGroup(dtoRequest);
    }

    public WordsGroupDtoResponse deleteGroup(Long id) {
        return groupDeleter.deleteById(id);
    }

    public AllWordsGroupDtoRequest findAllGroupByUser() {
        return groupRetriever.findAllGroupsByUser();
    }

    public WordsGroupDtoRequest findGroupByIdAndUser(Long id) {
        return groupRetriever.findGroupById(id);
    }

    public WordsGroupDtoRequest updateGroupName(Long groupId, UpdateGroupDtoRequest dtoRequest) {
        return groupUpdater.updateGroupNameById(groupId, dtoRequest);
    }

    public AddWordsToGroupDtoResponse addWordsToGroup(Long groupId, AddWordsToGroupDtoRequest request) {
        return wordAssigner.addWordsToGroup(groupId, request);
    }
}
