package main.java.dev.guedes.oracaopelajuventude.renderer;

import main.java.dev.guedes.oracaopelajuventude.raffler.Raffler;
import main.java.dev.guedes.oracaopelajuventude.util.TextFormatter;
import java.util.List;

/**
 * Console text renderer class.
 * Responsible for rendering various text-based outputs on the console for the application,
 * including prayer tables, prayer pairs, error messages, and other formatted text.
 *
 * @author João Guedes
 */
public class Renderer {

    private static final String TITLE = "ORAÇÃO PELA JUVENTUDE";
    private static final String BORDER = "=";
    public static final int LINE_WIDTH = 66;

    private Renderer() {

    }

    /**
     * Renders the entire table containing the information of who will pray for whom.
     * This method draws the header, processes the raffling of participants,
     * and then displays the footer.
     *
     * @param raffler The instance of the randomizer class that determines the prayer assignments.
     *
     * @param participants The list of participants who are involved in the prayer assignments.
     */
    public static void renderPrayerTable(Raffler raffler, List<String> participants) {
        renderHeader();
        raffler.draw(participants);
        renderFooter();
    }

    /**
     * Displays on the screen the information of the selected participant who will
     * pray for the selected participant receiving prayer.
     *
     * @param prayerGiver The participant who will be praying.
     *
     * @param prayerReceiver The participant who will receive the prayer.
     */
    public static void renderPrayerPair(String prayerGiver, String prayerReceiver) {
        String prayerMessage = String.format("%s ora por %s", prayerGiver, prayerReceiver);
        String[] wrappedText = TextFormatter.wrap(prayerMessage, LINE_WIDTH - 10);
        renderWrappedText(wrappedText);
    }

    /**
     * Renders an error message in the console with proper formatting.
     * Displays the error message inside a bordered box, centered, and wrapped to fit the screen.
     *
     * @param message The error message to be displayed.
     */
    public static void renderErrorMessage(String message) {
        renderHeader();
        String[] wrappedMessage = TextFormatter.wrap(message, LINE_WIDTH - 2);
        for (String line : wrappedMessage) {
            renderCentered(line);
        }
        renderFooter();
    }

    /**
     * Renders the header section of the output.
     * Includes the title and the border around the title.
     */
    private static void renderHeader() {
        renderBorder();
        renderCentered(TITLE);
        renderBorder();
        renderEmptyLine();
    }

    /**
     * Renders the footer section of the output.
     * Includes an empty line and the bottom border.
     */
    private static void renderFooter() {
        renderEmptyLine();
        renderBorder();
    }

    /**
     * Renders a borderline of the specified length.
     */
    private static void renderBorder() {
        System.out.println(BORDER.repeat(LINE_WIDTH));
    }

    /**
     * Renders the given text centered within a bordered box.
     * The text is padded with spaces to ensure it is centered within the line width.
     *
     * @param text The text to be rendered and centered.
     */
    private static void renderCentered(String text) {
        System.out.printf("|%s|%n", TextFormatter.center(text, LINE_WIDTH - 2));
    }

    /**
     * Renders an empty line within a bordered box.
     * This is used for spacing between content sections.
     */
    private static void renderEmptyLine() {
        System.out.printf("|%s|%n", " ".repeat(LINE_WIDTH - 2));
    }

    /**
     * Renders the wrapped text inside a bordered box.
     * Each line of the wrapped text is displayed with a specific format.
     *
     * @param wrappedText The array of wrapped lines to be rendered.
     */
    private static void renderWrappedText(String[] wrappedText) {
        System.out.printf("|  [*] %-" + (LINE_WIDTH - 8) + "s|%n", wrappedText[0]);
        for (int i = 1; i < wrappedText.length; i++) {
            System.out.printf("|      %-" + (LINE_WIDTH - 8) + "s|%n", wrappedText[i]);
        }
    }

}
