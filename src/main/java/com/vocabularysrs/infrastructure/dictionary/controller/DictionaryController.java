package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.dictionary.DictionaryFacade;
import com.vocabularysrs.domain.dictionary.WordHttpDto;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordUpdatePartiallyDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.GetAllWordsResponseDto;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordUpdatePartiallyDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordDtoResponseToWordDtoControllerResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordDtoresponseToGetAllWordsResponseDto;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryControllerDtoRequestToWordAddDtoRequest;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordHttpDtoToWordDetailsControllerDto;

@AllArgsConstructor
@RestController()
@RequestMapping("/words")
class DictionaryController {

    private final DictionaryFacade dictionaryFacade;

    @PostMapping()
    public ResponseEntity<WordEntryControllerDtoResponse> addWord(@RequestBody WordEntryControllerDtoRequest dtoRequest) {
        WordAddDtoRequest wordEntry = mapFromWordEntryControllerDtoRequestToWordAddDtoRequest(dtoRequest);
        WordEntryDtoResponse newWordEntry = dictionaryFacade.addWord(wordEntry);
        WordEntryControllerDtoResponse response = mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse(newWordEntry);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedWordEntryControllerDtoResponse> deleteWord(@PathVariable Long id) {
        WordEntryDtoResponse deletedWordEntry = dictionaryFacade.deleteWord(id);
        DeletedWordEntryControllerDtoResponse response = mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse(deletedWordEntry);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<GetAllWordsResponseDto> getAllWords(Pageable pageable) {
        List<WordDtoResponse> allWords = dictionaryFacade.findAllWords(pageable);
        GetAllWordsResponseDto getAllWordsResponseDto = mapFromWordDtoresponseToGetAllWordsResponseDto(allWords);
        return ResponseEntity.ok().body(getAllWordsResponseDto);
    }

    @GetMapping("/{wordEntryId}")
    public ResponseEntity<WordDtoControllerResponse> getAllWords(@PathVariable Long wordEntryId) {
        WordDtoResponse wordEntryById = dictionaryFacade.findById(wordEntryId);
        WordDtoControllerResponse response = mapFromWordDtoResponseToWordDtoControllerResponse(wordEntryById);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{wordEntryId}")
    public ResponseEntity<WordUpdatePartiallyDtoResponse> partiallyUpdateWordEntry(@PathVariable Long wordEntryId, @RequestBody WordUpdatePartiallyDtoRequest requestDto) {
        WordEntryUpdateDtoResponse wordEntryById = dictionaryFacade.updatePartiallyById(wordEntryId, requestDto);
        WordUpdatePartiallyDtoResponse response = mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse(wordEntryById);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{wordEntryId}/details")
    public ResponseEntity<WordDetailsControllerDto> getDetailsWord(@PathVariable Long wordEntryId) {
        WordHttpDto wordDetails = dictionaryFacade.getWordDetails(wordEntryId);
        WordDetailsControllerDto response = mapFromWordHttpDtoToWordDetailsControllerDto(wordDetails);
        return ResponseEntity.ok().body(response);
    }
}

