package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.shared.Language;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IrregularVerbFacadeTest {

    private final IrregularVerbRepository repository = mock(IrregularVerbRepository.class);
    private final IrregularVerbFacade facade = new IrregularVerbFacade(repository);

    @Test
    void shouldReturnVerbsForCurrentUserLanguage() {
        // given
        Language language = Language.RU;
        List<IrregularVerbDto> expected = List.of(new IrregularVerbDto("be", "[biː]", "was/were", "[wɒz]/[wɜː]", "been", "[biːn]", "быть"));

        when(repository.findAllByLanguage(language)).thenReturn(expected);
        // when
        List<IrregularVerbDto> result = facade.findAll(language);
        // then
        assertThat(result).isEqualTo(expected);
        verify(repository).findAllByLanguage(language);
    }
}