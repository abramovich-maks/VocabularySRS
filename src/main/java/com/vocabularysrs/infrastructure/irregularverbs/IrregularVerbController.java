package com.vocabularysrs.infrastructure.irregularverbs;

import com.vocabularysrs.domain.irregularverbs.IrregularVerbDto;
import com.vocabularysrs.domain.irregularverbs.IrregularVerbFacade;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.shared.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/verbs")
class IrregularVerbController {

    private final IrregularVerbFacade facade;
    private final CurrentUserProvider currentUserProvider;

    @GetMapping
    public List<IrregularVerbDto> getAll() {
        Language language = currentUserProvider.getCurrentUserLanguage();
        return facade.findAll(language);
    }
}

