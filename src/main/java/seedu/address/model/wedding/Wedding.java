package seedu.address.model.wedding;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Wedding in the system.
 * Guarantees: immutable; name is valid as declared in {@link #isValidWeddingName(String)}
 */
public class Wedding {
    public static final String MESSAGE_CONSTRAINTS =
            "Wedding names should only contain alphanumeric characters, spaces or apostrophes,"
                    + "and they should not be blank.";

    /**
     * Validation regex checks that first character of the wedding name must not be a whitespace,
     * so that " " (a blank string) is not a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}'][\\p{Alnum} ']*";
    private WeddingName weddingName;
    private int peopleCount;

    /**
     * Constructs a {@code Wedding} with the specified {@code weddingName}
     * @param weddingName A valid {@code WeddingName}
     */
    public Wedding(WeddingName weddingName) {
        requireNonNull(weddingName);
        this.weddingName = weddingName;
        this.peopleCount = 0;
    }

    /**
     * Returns true if a given string is a valid wedding name.
     */
    public static boolean isValidWeddingName(String checkName) {
        return checkName.matches(VALIDATION_REGEX);
    }

    /**
     * Returns wedding name associated with wedding
     * @return A {@code WeddingName} object representing the name of the wedding
     */
    public WeddingName getWeddingName() {
        return this.weddingName;
    }

    /**
     * Returns the number of people assigned to this wedding
     * @return An {@code int} with the number of people assigned to the wedding
     */
    public int getNumPersonsForWedding() {
        return this.peopleCount;
    }


    public void increasePeopleCount() {
        peopleCount++;
    }

    public void decreasePeopleCount() {
        peopleCount--;
    }

    /**
     * Returns true if the wedding can be deleted,
     * wedding can be deleted if {@code peopleCount} is 0.
     */
    public boolean canBeDeleted() {
        return (peopleCount == 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Wedding)) {
            return true;
        }

        Wedding otherWedding = (Wedding) obj;
        return weddingName.equals(otherWedding.weddingName);
    }

    /**
     * Returns true if another wedding has the same WeddingName as this wedding.
     * @param otherWedding A {@code Wedding} to compare with.
     */
    public boolean isSameWedding(Wedding otherWedding) {
        if (otherWedding == this) {
            return true;
        }

        // Wedding#equals(Object) covers the null case
        return otherWedding.getWeddingName().equals(getWeddingName());
    }

    @Override
    public int hashCode() {
        return weddingName.hashCode();
    }

    @Override
    public String toString() {
        return '[' + weddingName.toString() + '}';
    }
}
