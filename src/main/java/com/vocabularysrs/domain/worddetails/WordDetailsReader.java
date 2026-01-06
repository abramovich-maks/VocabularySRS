//package com.vocabularysrs.domain.worddetails;
//
//import com.vocabularysrs.domain.security.CurrentUserProvider;
//import lombok.AllArgsConstructor;
//
//import java.util.Optional;
//
//@AllArgsConstructor
//class WordDetailsReader {
//
//    private final WordDetailsRepository wordDetailsRepository;
//    private final CurrentUserProvider currentUserProvider;
//
//    Optional<WordHttpDto> getDetails(Long id) {
//        Long userId = currentUserProvider.getCurrentUserId();
//
//        return wordDetailsRepository.findByIdAndUserId(id, userId)
//                .map(details -> new WordHttpDto(
//                        details.getWordEntry().getWord(),
//                        details.getPhonetic(),
//                        details.getAudioUrl(),
//                        new WordHttpDetailsDto(
//                                details.getPartOfSpeech(),
//                                details.getDefinition(),
//                                details.getExample()
//                        )
//                ));
//    }
//}
