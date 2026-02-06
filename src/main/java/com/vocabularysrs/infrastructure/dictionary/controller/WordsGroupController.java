package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.words.WordsGroupFacade;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.UpdateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.CreateGroupRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.CreateGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeleteGroupResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromAddWordsToGroupDtoResponseToAssignWordsToGroupResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromAllWordsGroupDtoRequestToAllGroupsResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromAssignWordsToGroupRequestToAddWordsToGroupDtoRequest;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromUpdateGroupRequestToUpdateGroupDtoRequest;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordsGroupDtoRequestToUpdateGroupResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordsGroupDtoRequestToWordsGroupResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordsGroupDtoResponseToDeleteGroupResponse;

@AllArgsConstructor
@RestController()
@RequestMapping("/groups")
class WordsGroupController {

    private final WordsGroupFacade wordsGroupFacade;

    @PostMapping
    public ResponseEntity<CreateGroupResponse> createGroup(@RequestBody @Valid CreateGroupRequest request) {
        CreateGroupDtoRequest dtoRequest = CreateGroupDtoRequest.builder().groupName(request.groupName()).build();
        CreateGroupDtoResponse wordsGroup = wordsGroupFacade.createWordsGroup(dtoRequest);
        CreateGroupResponse response = CreateGroupResponse.builder().groupId(wordsGroup.groupId()).groupName(wordsGroup.groupName()).message(wordsGroup.message()).build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<AllGroupsResponse> findAllGroup() {
        AllWordsGroupDtoRequest allGroupByUser = wordsGroupFacade.findAllGroupByUser();
        return ResponseEntity.ok().body(mapFromAllWordsGroupDtoRequestToAllGroupsResponse(allGroupByUser));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<DeleteGroupResponse> deleteGroup(@PathVariable Long groupId) {
        WordsGroupDtoResponse wordsGroupDtoResponse = wordsGroupFacade.deleteGroup(groupId);
        DeleteGroupResponse response = mapFromWordsGroupDtoResponseToDeleteGroupResponse(wordsGroupDtoResponse);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<UpdateGroupResponse> updateNameGroup(@PathVariable Long groupId, @RequestBody UpdateGroupRequest request) {
        UpdateGroupDtoRequest build = mapFromUpdateGroupRequestToUpdateGroupDtoRequest(request);
        WordsGroupDtoRequest updatedGroup = wordsGroupFacade.updateGroupName(groupId, build);
        UpdateGroupResponse response = mapFromWordsGroupDtoRequestToUpdateGroupResponse(updatedGroup);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{groupId}/add/words")
    public ResponseEntity<AssignWordsToGroupResponse> assignWordsToGroup(@PathVariable Long groupId, @RequestBody AssignWordsToGroupRequest request) {
        AddWordsToGroupDtoRequest build = mapFromAssignWordsToGroupRequestToAddWordsToGroupDtoRequest(request);
        AddWordsToGroupDtoResponse assign = wordsGroupFacade.addWordsToGroup(groupId, build);
        AssignWordsToGroupResponse response = mapFromAddWordsToGroupDtoResponseToAssignWordsToGroupResponse(assign);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<WordsGroupResponse> getGroupById(@PathVariable Long groupId) {
        WordsGroupDtoRequest group = wordsGroupFacade.findGroupByIdAndUser(groupId);
        WordsGroupResponse response = mapFromWordsGroupDtoRequestToWordsGroupResponse(group);
        return ResponseEntity.ok().body(response);
    }
}
