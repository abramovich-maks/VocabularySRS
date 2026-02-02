package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsGroupFacadeTest {

    private final CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    WordsGroupRepository wordsGroupRepository = new InMemoryWordsGroupRepositoryTestImpl();
    WordsGroupFacade wordsGroupFacade = new WordEntryConfiguration().wordsGroupFacade(wordsGroupRepository, currentUserProvider);

    @Test
    public void should_return_success_when_user_add_new_group() {
        // given
        CreateGroupDtoRequest dtoRequest = new CreateGroupDtoRequest("Animals");
        // when
        CreateGroupDtoResponse wordsGroup = wordsGroupFacade.createWordsGroup(dtoRequest);
        // then
        assertAll(
                () -> assertThat(wordsGroup.message()).isEqualTo("Created new group"),
                () -> assertThat(wordsGroup.groupId()).isEqualTo(0),
                () -> assertThat(wordsGroup.groupName()).isEqualTo("Animals")
        );
    }

    @Test
    public void should_throw_exception_when_user_creates_group_with_existing_name() {
        // given
        CreateGroupDtoRequest dtoRequest = new CreateGroupDtoRequest("Animals");
        CreateGroupDtoRequest requestWithSpase = new CreateGroupDtoRequest("Animals       ");
        wordsGroupFacade.createWordsGroup(dtoRequest);
        // when
        WordsGroupAlreadyExistsException exception = assertThrows(WordsGroupAlreadyExistsException.class, () -> wordsGroupFacade.createWordsGroup(requestWithSpase));
        //then
        assertThat(exception.getMessage()).isEqualTo("Group with name \"Animals\" already exists");
    }

    @Test
    public void should_return_error_when_user_gave_null_group_name() {
        // given
        CreateGroupDtoRequest dtoRequest = new CreateGroupDtoRequest(null);
        // when
        InvalidWordsGroupException exception = assertThrows(InvalidWordsGroupException.class, () -> wordsGroupFacade.createWordsGroup(dtoRequest));
        // then
        assertThat(exception.getMessage()).isEqualTo("Group name must not be null");

    }
}