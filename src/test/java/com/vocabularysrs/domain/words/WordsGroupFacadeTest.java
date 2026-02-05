package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.AddWordsToGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.AllWordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.CreateGroupDtoResponse;
import com.vocabularysrs.domain.words.dto.UpdateGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import com.vocabularysrs.domain.words.dto.WordsGroupDtoResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsGroupFacadeTest {

    private final CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    private final WordsGroupRepository wordsGroupRepository = new InMemoryWordsGroupRepositoryTestImpl();
    private final WordGroupLinkRepository linkRepository = new InMemoryWordGroupLinkRepositoryTestImpl();
    private final InMemoryWordEntryRepositoryTestImpl wordRepository = new InMemoryWordEntryRepositoryTestImpl();
    private final WordsGroupFacade wordsGroupFacade = new WordEntryConfiguration().wordsGroupFacade(wordsGroupRepository, currentUserProvider, linkRepository, wordRepository);

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

    @Test
    public void should_throw_an_exception_when_user_want_delete_group_by_not_exist_id() {
        // given
        CreateGroupDtoRequest dtoRequest = new CreateGroupDtoRequest("Animals");
        CreateGroupDtoResponse wordsGroup = wordsGroupFacade.createWordsGroup(dtoRequest);
        // when
        WordsGroupNotFoundException exception = assertThrows(WordsGroupNotFoundException.class, () -> wordsGroupFacade.deleteGroup(1L));
        // then
        assertThat(wordsGroup.groupId()).isEqualTo(0L);
        assertThat(exception.getMessage()).isEqualTo("Group with id: 1 not found");
    }

    @Test
    public void should_deleted_message_when_user_want_delete_group_by_exist_id() {
        // given
        CreateGroupDtoRequest dtoRequest = new CreateGroupDtoRequest("Animals");
        wordsGroupFacade.createWordsGroup(dtoRequest);
        // when
        WordsGroupDtoResponse deleted = wordsGroupFacade.deleteGroup(0L);
        // then
        assertThat(deleted.message()).isEqualTo("Deleted group by id: 0");
        assertThrows(WordsGroupNotFoundException.class, () -> wordsGroupFacade.deleteGroup(0L));
    }

    @Test
    public void should_all_groups_by_current_user() {
        //given
        CreateGroupDtoRequest group1 = new CreateGroupDtoRequest("Animals");
        CreateGroupDtoRequest group2 = new CreateGroupDtoRequest("Travels");
        CreateGroupDtoRequest group3 = new CreateGroupDtoRequest("Work");
        wordsGroupFacade.createWordsGroup(group1);
        wordsGroupFacade.createWordsGroup(group2);
        wordsGroupFacade.createWordsGroup(group3);
        //when
        AllWordsGroupDtoRequest allGroupByUser = wordsGroupFacade.findAllGroupByUser();
        //then
        assertAll(
                () -> assertThat(allGroupByUser.group()).hasSize(3)
        );
    }

    @Test
    public void should_return_exist_group_by_id() {
        // given
        CreateGroupDtoRequest group1 = new CreateGroupDtoRequest("Animals");
        wordsGroupFacade.createWordsGroup(group1);
        // when
        WordsGroupDtoRequest group = wordsGroupFacade.findGroupByIdAndUser(0L);
        // then
        assertAll(
                () -> assertThat(group.groupId()).isEqualTo(0),
                () -> assertThat(group.groupName()).isEqualTo("Animals")
        );
    }

    @Test
    public void should_return_group_with_new_updated_name() {
        // given
        CreateGroupDtoRequest group1 = new CreateGroupDtoRequest("Animals");
        wordsGroupFacade.createWordsGroup(group1);
        WordsGroupDtoRequest oldGroupName = wordsGroupFacade.findGroupByIdAndUser(0L);
        assertThat(oldGroupName.groupName()).isEqualTo("Animals");
        // when
        UpdateGroupDtoRequest updateGroupDtoRequest = new UpdateGroupDtoRequest(0L, "Animals 2 - update");
        WordsGroupDtoRequest updateGroupName = wordsGroupFacade.updateGroupName(updateGroupDtoRequest);
        // then
        WordsGroupDtoRequest newGroupName = wordsGroupFacade.findGroupByIdAndUser(0L);
        assertAll(
                () -> assertThat(updateGroupName.groupName()).isEqualTo("Animals 2 - update"),
                () -> assertThat(newGroupName.groupName()).isEqualTo("Animals 2 - update")
        );
    }

    @Test
    void should_add_two_words_to_group() {
        // given
        CreateGroupDtoResponse group = wordsGroupFacade.createWordsGroup(new CreateGroupDtoRequest("Animals"));
        WordEntry savedWord = wordRepository.save(WordEntry.builder()
                .word("cat")
                .translate("кот")
                .userId(currentUserProvider.getCurrentUserId()).build());
        WordEntry savedWord2 = wordRepository.save(WordEntry.builder()
                .word("dog")
                .translate("собака")
                .userId(currentUserProvider.getCurrentUserId()).build());
        // when
        AddWordsToGroupDtoResponse response = wordsGroupFacade.addWordsToGroup(new AddWordsToGroupDtoRequest(group.groupId(), List.of(savedWord.getId(), savedWord2.getId())));
        // then
        assertAll(
                () -> assertThat((response.groupName())).isEqualTo("Animals"),
                () -> assertThat(response.countAddedWords()).isEqualTo(2)
        );
    }
}