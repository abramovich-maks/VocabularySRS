package com.vocabularysrs.infrastructure.dictionary.http;


import com.vocabularysrs.domain.dictionary.WordDetailsFetchable;
import com.vocabularysrs.domain.dictionary.WordHttpDto;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DictionaryApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

import static com.vocabularysrs.infrastructure.dictionary.http.DictionaryApiResponseMapper.mapToWordHttpDto;

@Log4j2
@AllArgsConstructor
public class WordDetailsRestTemplate implements WordDetailsFetchable {

    private final RestTemplate restTemplate;
    private final String uri;


    private String getUrlForWord(String word) {
        return uri + word;
    }


    @Override
    public WordHttpDto details(final String word) {
        String url = getUrlForWord(word);

        DictionaryApiResponse[] response =
                restTemplate.getForObject(url, DictionaryApiResponse[].class);

        if (response == null || response.length == 0) {
            throw new IllegalStateException("Empty dictionary response for word: " + word);
        }

        DictionaryApiResponse entry = response[0];

        return mapToWordHttpDto(entry);
    }
}