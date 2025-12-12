package com.vocabularysrs.infrastructure.dictionary;

import com.vocabularysrs.domain.dictionary.DictionaryFacade;
import com.vocabularysrs.domain.dictionary.WordEntryDtoResponse;
import com.vocabularysrs.domain.dictionary.dto.WordAddDtoRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vocabularysrs.infrastructure.dictionary.DictionaryControllerMapper.mapFromWordEntryControllerDtoRequestToWordAddDtoRequest;
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
}

