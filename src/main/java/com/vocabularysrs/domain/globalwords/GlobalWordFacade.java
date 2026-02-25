package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.globalwords.dto.GlobalWordResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GlobalWordFacade {

    private final GlobalWordAdder wordAdder;

    public GlobalWordResponse addWordToGlobal(GlobalWordRequest request) {
        return wordAdder.addWordToGlobal(request.word());
    }

}
