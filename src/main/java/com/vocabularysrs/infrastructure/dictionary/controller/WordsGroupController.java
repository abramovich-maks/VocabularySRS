package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.words.WordsGroupFacade;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.CreateGroupRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.CreateGroupResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeleteGroupResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromAllWordsGroupDtoRequestToAllGroupsResponse;

@AllArgsConstructor
@RestController()
@RequestMapping("/groups")
class WordsGroupController {

    private final WordsGroupFacade wordsGroupFacade;

    @PostMapping
    public ResponseEntity<CreateGroupResponse> createGroup(@RequestBody CreateGroupRequest request) {
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
        DeleteGroupResponse response = DeleteGroupResponse.builder().groupName(wordsGroupDtoResponse.groupName()).message(wordsGroupDtoResponse.message()).build();
        return ResponseEntity.ok().body(response);
    }
}
