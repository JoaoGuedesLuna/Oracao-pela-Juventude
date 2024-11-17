package main.java.dev.guedes.oracaopelajuventude;

import main.java.dev.guedes.oracaopelajuventude.raffler.PrayerPairRaffler;
import main.java.dev.guedes.oracaopelajuventude.renderer.Renderer;
import main.java.dev.guedes.oracaopelajuventude.util.ArgsHelper;

/**
 * Represents the core application logic of the OracaoPelaJuventude system.
 * <p>
 * This class is responsible for handling the main application flow, including the logic
 * of raffling prayer pairs and rendering the results to the user. It uses the {@link PrayerPairRaffler}
 * to determine the pairs and the {@link Renderer} to display the output. The {@link ArgsHelper}
 * class assists in processing command-line arguments.
 * </p>
 *
 * @author João Guedes
 */
public class GuedesApplication {

    private GuedesApplication() {

    }

    public static void run(String[] args) {
        try {
            Renderer.renderPrayerTable(new PrayerPairRaffler(), ArgsHelper.toList(args));
        } catch (Exception e) {
            Renderer.renderErrorMessage(e.getMessage());
        }
    }

}
