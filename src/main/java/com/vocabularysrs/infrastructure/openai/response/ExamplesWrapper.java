package com.vocabularysrs.infrastructure.openai.response;

import java.util.List;

public record ExamplesWrapper(
        List<String> examples
) {
}
