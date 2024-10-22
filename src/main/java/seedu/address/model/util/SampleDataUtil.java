package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;
import seedu.address.model.task.Task;
import seedu.address.model.wedding.Wedding;
import seedu.address.model.wedding.WeddingName;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"),
                getWeddingSet("Casey's Wedding"),
                getTaskSet("Finalize Catering Menu")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends"),
                getWeddingSet(),
                getTaskSet("Set Up Venue Decorations")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours"),
                getWeddingSet("Wedding August 2029", "Wedding 2"),
                getTaskSet("Send invitations")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family"),
                getWeddingSet(),
                getTaskSet("Order wedding cake")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates"),
                getWeddingSet("Casey's Wedding"),
                getTaskSet("Schedule Hair and Makeup Trials")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"),
                getWeddingSet("Wedding 10"),
                getTaskSet("Schedule Hair and Makeup Trials"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of tags given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(TagName::new)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a task set containing the list of tasks given.
     */
    public static Set<Task> getTaskSet(String... strings) {
        return Arrays.stream(strings)
                .map(Task::new)
                .collect(Collectors.toSet());
    }


    /**
     * Returns a wedding set containing the list of weddings given.
     */
    public static Set<Wedding> getWeddingSet(String... strings) {
        return Arrays.stream(strings)
                .map(WeddingName::new)
                .map(Wedding::new)
                .collect(Collectors.toSet());
    }

}
