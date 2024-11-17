package main.java.dev.guedes.oracaopelajuventude.raffler;

import java.util.List;

/**
 * Interface for the Raffler functionality.
 * <p>
 * Defines the contract for classes that implement the raffling behavior.
 * The implementing class should provide logic to perform a raffle (random selection) from a list of names.
 * </p>
 * <p>
 * This interface defines a single method {@link #draw(List)} to be implemented by any class that wants to
 * perform a raffle operation on a list of names or items.
 * </p>
 *
 * @author João Guedes
 */
@FunctionalInterface
public interface Raffler {

    /**
     * Performs a raffle (random selection) from the provided list of names.
     * <p>
     * The implementing class should define the specific logic of how the raffle is conducted, such as selecting
     * a random name or applying certain conditions to the list of names.
     * </p>
     *
     * @param list A list of names (or other items) from which the raffle will select. The list may not be null and should contain the items from which a random choice will be made.
     *
     * @throws IllegalArgumentException if the list is null or empty.
     */
    void draw(List<String> list);

}
