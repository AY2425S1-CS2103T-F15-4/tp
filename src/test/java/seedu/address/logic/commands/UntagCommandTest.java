package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;
import seedu.address.model.wedding.Wedding;
import seedu.address.model.wedding.WeddingName;

public class UntagCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());


    @Test
    public void execute_validTagsUnfilteredList_success() {
        Person personToEdit = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        HashSet<Tag> tagsToRemove = new HashSet<>(Arrays.asList(new Tag(new TagName("friends"))));

        UntagCommand untagCommand = new UntagCommand(INDEX_FIRST_PERSON, tagsToRemove);

        String expectedMessage = String.format(UntagCommand.MESSAGE_REMOVE_TAG_SUCCESS,
                "friends", personToEdit.getName().toString());

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        Set<Tag> updatedTags = new HashSet<>(personToEdit.getTags());
        updatedTags.removeAll(tagsToRemove);
        Person editedPerson = new Person(
                personToEdit.getName(),
                personToEdit.getPhone(),
                personToEdit.getEmail(),
                personToEdit.getAddress(),
                updatedTags,
                personToEdit.getWeddings());
        expectedModel.setPerson(personToEdit, editedPerson);

        CommandTestUtil.assertCommandSuccess(untagCommand, model, expectedMessage, expectedModel);
    }


    @Test
    public void execute_validMultipleTagsUnfilteredList_success() {
        Person personWithTags = new Person(
                new seedu.address.model.person.Name("Test Person"),
                new seedu.address.model.person.Phone("99999999"),
                new seedu.address.model.person.Email("test@example.com"),
                new seedu.address.model.person.Address("123, Test Street"),
                new HashSet<>(Arrays.asList(new Tag(new TagName("friends")), new Tag(new TagName("owesMoney")))),
                new HashSet<>(Arrays.asList(new Wedding(new WeddingName("Jiazhen's Wedding")),
                        new Wedding(new WeddingName("Wedding 29th August"))))
        );
        model.setPerson(model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()), personWithTags);
        HashSet<Tag> tagsToRemove = new HashSet<>(Arrays.asList(new Tag(new TagName("friends")),
                new Tag(new TagName("owesMoney"))));
        UntagCommand untagCommand = new UntagCommand(INDEX_FIRST_PERSON, tagsToRemove);
        String expectedMessage = String.format(UntagCommand.MESSAGE_REMOVE_TAG_SUCCESS,
                "owesMoney, friends", personWithTags.getName().toString());

        // Create the expected model with the updated tags (i.e., an empty set of tags)
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        HashSet<Tag> updatedTags = new HashSet<>(personWithTags.getTags());
        updatedTags.removeAll(tagsToRemove);
        Person editedPerson = new Person(
                personWithTags.getName(),
                personWithTags.getPhone(),
                personWithTags.getEmail(),
                personWithTags.getAddress(),
                updatedTags,
                personWithTags.getWeddings());
        expectedModel.setPerson(personWithTags, editedPerson);

        CommandTestUtil.assertCommandSuccess(untagCommand, model, expectedMessage, expectedModel);
    }


    @Test
    public void execute_nonExistentTag_failure() {
        HashSet<Tag> tagsToRemove = new HashSet<>(Arrays.asList(new Tag(new TagName("nonExistentTag"))));
        UntagCommand untagCommand = new UntagCommand(INDEX_FIRST_PERSON, tagsToRemove);
        String expectedMessage = Messages.MESSAGE_TAG_NOT_FOUND_IN_CONTACT;
        CommandTestUtil.assertCommandFailure(untagCommand, model, expectedMessage);
    }


    @Test
    public void execute_noTagsSpecified_failure() {
        // No tags specified to remove
        HashSet<Tag> emptyTagsToRemove = new HashSet<>(Arrays.asList());
        UntagCommand untagCommand = new UntagCommand(INDEX_FIRST_PERSON, emptyTagsToRemove);
        String expectedMessage = Messages.MESSAGE_TAG_NOT_FOUND_IN_CONTACT;
        CommandTestUtil.assertCommandFailure(untagCommand, model, expectedMessage);
    }


    @Test
    public void execute_invalidIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        HashSet<Tag> tagsToRemove = new HashSet<>(Arrays.asList(new Tag(new TagName("friends"))));

        UntagCommand untagCommand = new UntagCommand(outOfBoundIndex, tagsToRemove);

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        CommandTestUtil.assertCommandFailure(untagCommand, model, expectedMessage);
    }


    @Test
    public void execute_personWithoutTags_failure() {
        Person personWithoutTags = new Person(
                new seedu.address.model.person.Name("Test Person"),
                new seedu.address.model.person.Phone("99999999"),
                new seedu.address.model.person.Email("test@example.com"),
                new seedu.address.model.person.Address("123, Test Street"),
                new HashSet<>(), // No tags
                new HashSet<>(Arrays.asList(new Wedding(new WeddingName("Jiazhen's Wedding")),
                        new Wedding(new WeddingName("Wedding 29th August"))))
        );

        model.setPerson(model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased()), personWithoutTags);
        HashSet<Tag> tagsToRemove = new HashSet<>(Arrays.asList(new Tag(new TagName("friends"))));
        UntagCommand untagCommand = new UntagCommand(INDEX_SECOND_PERSON, tagsToRemove);
        String expectedMessage = Messages.MESSAGE_TAG_NOT_FOUND_IN_CONTACT;

        CommandTestUtil.assertCommandFailure(untagCommand, model, expectedMessage);
    }
}
