package com.vocabularysrs.infrastructure.dictionary;

import com.vocabularysrs.domain.dictionary.DictionaryFacade;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordEntryDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.dto.GetAllWordsResponseDto;
import com.vocabularysrs.infrastructure.dictionary.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.dto.WordEntryControllerDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.vocabularysrs.infrastructure.dictionary.DictionaryControllerMapper.mapFromWordDtoresponseToGetAllWordsResponseDto;
import static com.vocabularysrs.infrastructure.dictionary.DictionaryControllerMapper.mapFromWordEntryControllerDtoRequestToWordAddDtoRequest;
import static com.vocabularysrs.infrastructure.dictionary.DictionaryControllerMapper.mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.DictionaryControllerMapper.mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse;

@AllArgsConstructor
@RestController()
@RequestMapping("/words")
class DictionaryController {

    private final DictionaryFacade dictionaryFacade;

    @PostMapping("/add")
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
}

