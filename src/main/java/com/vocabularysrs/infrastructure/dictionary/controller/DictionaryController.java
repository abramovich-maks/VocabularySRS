package com.vocabularysrs.infrastructure.dictionary.controller;

import com.vocabularysrs.domain.worddetails.WordDetailsFacade;
import com.vocabularysrs.domain.worddetails.dto.WordHttpDto;
import com.vocabularysrs.domain.words.dto.WordWithAutoTranslateDtoRequest;
import com.vocabularysrs.domain.words.WordsFacade;
import com.vocabularysrs.domain.words.dto.WordAddDtoRequest;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryDtoResponse;
import com.vocabularysrs.domain.words.dto.WordEntryUpdateDtoResponse;
import com.vocabularysrs.domain.words.dto.WordUpdatePartiallyDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryWithAutoTranslateControllerDtoRequest;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordUpdatePartiallyDtoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordDtoResponseToWordDtoControllerResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryControllerDtoRequestToWordAddDtoRequest;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse;
import static com.vocabularysrs.infrastructure.dictionary.controller.DictionaryControllerMapper.mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse;

@AllArgsConstructor
@RestController()
@RequestMapping("/words")
class DictionaryController {

    private final WordsFacade wordsFacade;
    private final WordDetailsFacade wordDetailsFacade;

    @PostMapping()
    public ResponseEntity<WordEntryControllerDtoResponse> addWord(@RequestBody @Valid WordEntryControllerDtoRequest dtoRequest) {
        WordAddDtoRequest wordEntry = mapFromWordEntryControllerDtoRequestToWordAddDtoRequest(dtoRequest);
        WordEntryDtoResponse newWordEntry = wordsFacade.addWord(wordEntry);
        WordEntryControllerDtoResponse response = mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse(newWordEntry);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/auto")
    public ResponseEntity<WordEntryControllerDtoResponse> addWordWithAutoTranslate(@RequestBody @Valid WordEntryWithAutoTranslateControllerDtoRequest dtoRequest) {
        WordWithAutoTranslateDtoRequest build = WordWithAutoTranslateDtoRequest.builder().word(dtoRequest.word()).build();
        WordEntryDtoResponse newWordEntry = wordsFacade.addWordWithAutoTranslate(build);
        WordEntryControllerDtoResponse response = mapFromWordEntryDtoResponseToWordEntryControllerDtoResponse(newWordEntry);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedWordEntryControllerDtoResponse> deleteWord(@PathVariable Long id) {
        WordEntryDtoResponse deletedWordEntry = wordsFacade.deleteWord(id);
        DeletedWordEntryControllerDtoResponse response = mapFromWordEntryDtoResponseToDeletedWordEntryControllerDtoResponse(deletedWordEntry);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public Page<WordDtoControllerResponse> getAllWords(Pageable pageable) {
        return wordsFacade.findAllWords(pageable)
                .map(DictionaryControllerMapper::mapFromWordDtoResponseToWordDtoControllerResponse);
    }

    @GetMapping("/{wordEntryId}")
    public ResponseEntity<WordDtoControllerResponse> getWordById(@PathVariable Long wordEntryId) {
        WordDtoResponse wordEntryById = wordsFacade.findById(wordEntryId);
        WordDtoControllerResponse response = mapFromWordDtoResponseToWordDtoControllerResponse(wordEntryById);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{wordEntryId}")
    public ResponseEntity<WordUpdatePartiallyDtoResponse> partiallyUpdateWordEntry(@PathVariable Long wordEntryId, @RequestBody WordUpdatePartiallyDtoRequest requestDto) {
        WordEntryUpdateDtoResponse wordEntryById = wordsFacade.updatePartiallyById(wordEntryId, requestDto);
        WordUpdatePartiallyDtoResponse response = mapFromWordEntryUpdateDtoResponseToWordUpdatePartiallyDtoResponse(wordEntryById);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{wordEntryId}/details")
    public ResponseEntity<WordDetailsControllerDto> getDetailsWord(@PathVariable Long wordEntryId) {
        WordHttpDto details = wordDetailsFacade.getOrLoad(wordEntryId);
        WordDetailsControllerDto build = WordDetailsControllerDto.builder().phonetic(details.phonetic()).audioUrl(details.audioUrl()).example(details.example()).alternativeTranslate(details.alternatives()).build();
        return ResponseEntity.ok(build);
    }
}

