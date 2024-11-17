package main.java.dev.guedes.oracaopelajuventude.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for formatting text, including methods for centering and wrapping text within specified column widths.
 * This class is not meant to be instantiated, as it only contains static methods.
 *
 * @author João Guedes
 */
public class TextFormatter {

    private TextFormatter() {

    }

    /**
     * Centers the given text within the specified number of columns.
     *
     * @param text the text to center.
     *
     * @param columns the total number of columns to center the text within.
     *
     * @return a string with the text centered within the specified number of columns.
     */
    public static String center(String text, int columns) {
        checkNotNull(text);
        checkPositiveColumns(columns);

        int totalSpaces = columns - text.length();
        if (totalSpaces <= 0) return  text;

        int rightPadding = totalSpaces / 2;
        int leftPadding = totalSpaces - rightPadding;

        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    /**
     * Breaks the given text into multiple lines based on the specified maximum number of columns.
     * The text will be wrapped such that no line exceeds the given column width, and words will not
     * be split across lines.
     *
     * @param text The text to wrap. It should not be null or empty.
     *
     * @param columns The maximum number of columns per line. This value must be positive.
     *
     * @return An array of strings, where each string represents a wrapped line of text.
     *         The lines will not exceed the specified number of columns.
     *
     * @throws NullPointerException If the input text is null.
     *
     * @throws IllegalArgumentException If the number of columns is less than or equal to zero.
     */
    public static String[] wrap(String text, int columns) {
        checkNotNull(text);
        checkPositiveColumns(columns);

        String[] segments = splitIntoWordsAndWhitespaces(text);
        List<String> wrappedText = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String segment : segments) {
            if (!currentLine.isEmpty() && !segment.isBlank() && (currentLine.length() + segment.length() > columns)) {
                wrappedText.add(currentLine.toString());
                currentLine.setLength(0);
            }

            currentLine.append(segment);

            if (currentLine.length() > columns) {
                String[] wrappedLine = wrapLine(currentLine.toString(), columns);
                wrappedText.addAll(Arrays.asList(wrappedLine).subList(0, wrappedLine.length - 1));
                currentLine.setLength(0);
                currentLine.append(wrappedLine[wrappedLine.length - 1]);
            }
        }

        if (!currentLine.isEmpty()) {
            wrappedText.add(currentLine.toString());
        }

        return wrappedText.toArray(new String[0]);
    }

    /**
     * Splits the given input string into words and whitespace segments.
     * It separates words and whitespace sequences, preserving their order.
     *
     * @param text the string to be split into words and whitespace.
     *
     * @return an array of strings, each representing either a word or a sequence of whitespace.
     */
    private static String[] splitIntoWordsAndWhitespaces(String text) {
        Pattern pattern = Pattern.compile("\\S+|\\s+");
        Matcher matcher = pattern.matcher(text);

        List<String> segments = new ArrayList<>();

        while (matcher.find()) {
            segments.add(matcher.group());
        }

        return segments.toArray(new String[0]);
    }

    /**
     * Wraps a line of text into multiple lines based on the specified column width.
     *
     * @param line the text to wrap.
     *
     * @param columns the number of columns per line.
     *
     * @return an array of strings representing the wrapped text.
     */
    private static String[] wrapLine(String line, int columns) {
        List<String> wrappedLines = new ArrayList<>();

        for (int i = 0; i < line.length(); i += columns) {
            int end = Math.min(line.length(), i + columns);
            wrappedLines.add(line.substring(i, end));
        }

        return wrappedLines.toArray(new String[0]);
    }

    /**
     * Checks if the provided text is null.
     * Throws an exception if it is.
     *
     * @param text the string to check.
     *
     * @throws NullPointerException if text is null.
     */
    private static void checkNotNull(String text) {
        if (text == null) {
            throw new NullPointerException("Text cannot be null.");
        }
    }

    /**
     * Checks if the number of columns is positive.
     * Throws an exception if columns is zero or negative.
     *
     * @param columns the number of columns to check.
     *
     * @throws IllegalArgumentException if columns is zero or negative.
     */
    private static void checkPositiveColumns(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("Columns must be greater than zero.");
        }
    }

}
