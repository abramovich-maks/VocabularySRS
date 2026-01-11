package com.vocabularysrs.infrastructure.translation.controller;

import com.vocabularysrs.domain.translation.TranslateFacade;
import com.vocabularysrs.domain.translation.TranslationResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/translate")
@RestController
@AllArgsConstructor
class TestController {

    private final TranslateFacade translateFacade;

    @PostMapping()
    public TranslationResult test(@RequestBody TranslateRequest request) {
        return translateFacade.getTranslate(request.word());
    }
}
// todo marked for deletion