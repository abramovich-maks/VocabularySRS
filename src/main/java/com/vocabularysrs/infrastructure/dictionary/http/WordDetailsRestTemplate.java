package com.vocabularysrs.infrastructure.dictionary.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
import com.vocabularysrs.domain.worddetails.WordNotFoundInDictionaryException;
import com.vocabularysrs.domain.words.WordDetailsSnapshot;
import com.vocabularysrs.infrastructure.dictionary.http.dto.DictionaryApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.vocabularysrs.infrastructure.dictionary.http.DictionaryApiResponseMapper.mapToWordHttpDto;

@Log4j2
@AllArgsConstructor
public class WordDetailsRestTemplate implements WordDetailsFetchable {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String uri;


    private String getUrlForWord(String word) {
        return uri + word;
    }


    @Override
    public WordDetailsSnapshot fetch(String word) {
        String url = getUrlForWord(word);
        try {
            String responseBody = restTemplate.getForObject(url, String.class);

            DictionaryApiResponse[] response =
                    objectMapper.readValue(responseBody, DictionaryApiResponse[].class);

            if (response == null || response.length == 0) {
                throw new WordNotFoundInDictionaryException(word);
            }

            DictionaryApiResponse entry = response[0];

            return mapToWordHttpDto(entry);
        } catch (HttpClientErrorException.NotFound ex) {
            log.warn("Word '{}' not found in dictionary", word);
            throw new WordNotFoundInDictionaryException(word);

        } catch (HttpClientErrorException ex) {
            log.error("Dictionary client error for word '{}'", word, ex);
            throw new RuntimeException("Dictionary client error");

        } catch (org.springframework.web.client.ResourceAccessException ex) {
            log.error("Dictionary API unavailable while fetching '{}'", word, ex);
            throw new DictionaryUnavailableException(
                    "Dictionary service is temporarily unavailable. Try again later."
            );
        } catch (Exception ex) {
            log.error("Unexpected error while fetching word '{}'", word, ex);
            throw new RuntimeException("Dictionary error");
        }
    }
}