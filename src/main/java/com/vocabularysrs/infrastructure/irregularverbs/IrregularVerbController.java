package com.vocabularysrs.infrastructure.irregularverbs;

import com.vocabularysrs.domain.irregularverbs.IrregularVerbDto;
import com.vocabularysrs.domain.irregularverbs.IrregularVerbFacade;
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

    @GetMapping
    public List<IrregularVerbDto> getAll() {
        return facade.findAll();
    }
}

