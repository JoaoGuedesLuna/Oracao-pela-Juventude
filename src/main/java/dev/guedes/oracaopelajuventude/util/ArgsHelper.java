package main.java.dev.guedes.oracaopelajuventude.util;

import main.java.dev.guedes.oracaopelajuventude.exception.InvalidArgumentException;
import main.java.dev.guedes.oracaopelajuventude.exception.NoArgumentsException;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class that provides methods for processing an array of arguments.
 * This class contains a static method for converting an array of arguments into a
 * list, ensuring that the arguments are valid and properly formatted.
 * This class cannot be instantiated.
 *
 * @author João Guedes
 */
public class ArgsHelper {

    private ArgsHelper() {

    }

    /**
     * Converts a single comma-separated string argument into a list of unique, non-blank strings.
     * Throws exceptions if the input is invalid (empty, blank, or contains multiple arguments).
     *
     * @param args an array containing a single string with comma-separated values.
     *
     * @return a list of unique, non-blank strings.
     *
     * @throws NoArgumentsException if the argument is empty or results in an empty list.
     *
     * @throws InvalidArgumentException if more than one argument is provided.
     */
    public static List<String> toList(String[] args) throws NoArgumentsException, InvalidArgumentException{
        if (args.length == 0) {
            throw new NoArgumentsException();
        }

        if (args.length > 1) {
            throw new InvalidArgumentException();
        }

        List<String> parsedArgs = Arrays.stream(args[0].split(","))
                .map(String::trim)
                .filter(arg -> !arg.isBlank())
                .distinct()
                .toList();

        if (parsedArgs.isEmpty()) {
            throw new NoArgumentsException();
        }

        return parsedArgs;
    }

}
