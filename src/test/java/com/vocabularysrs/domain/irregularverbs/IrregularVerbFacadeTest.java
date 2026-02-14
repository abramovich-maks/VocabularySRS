package com.vocabularysrs.domain.irregularverbs;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.shared.Language;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IrregularVerbFacadeTest {

    private final IrregularVerbRepository repository = mock(IrregularVerbRepository.class);
    private final CurrentUserProvider currentUserProvider = mock(CurrentUserProvider.class);

    private final IrregularVerbFacade facade = new IrregularVerbFacade(repository, currentUserProvider);

    @Test
    void shouldReturnVerbsForCurrentUserLanguage() {
        // given
        Language language = Language.RU;
        List<IrregularVerbDto> expected = List.of(new IrregularVerbDto("be", "[biː]", "was/were", "[wɒz]/[wɜː]", "been", "[biːn]", "быть"));

        when(currentUserProvider.getCurrentUserLanguage()).thenReturn(language);
        when(repository.findAllByLanguage(language)).thenReturn(expected);
        // when
        List<IrregularVerbDto> result = facade.findAll();
        // then
        assertThat(result).isEqualTo(expected);
        verify(currentUserProvider).getCurrentUserLanguage();
        verify(repository).findAllByLanguage(language);
    }
}