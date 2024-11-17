package main.java.dev.guedes.oracaopelajuventude.exception;

/**
 * Custom exception thrown when an invalid argument is provided.
 * Extends IllegalArgumentException to indicate that the argument passed to a method is invalid.
 *
 * @author João Guedes
 */
public class InvalidArgumentException extends IllegalArgumentException {

    private static final String DEFAULT_ERROR_MESSAGE =
            "Argumento inválido. Quando executado via CLI, todos os nomes devem estar envolvidos por aspas (\" \"). " +
            "Exemplo: \"Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay\". " +
            "Cada nome deve ser separado por vírgula. " +
            "As aspas devem envolver todos os nomes juntos. " +
            "Por exemplo: \"Marcelo Luna, Solange Guedes\" (e não \"Marcelo Luna\", \"Solange Guedes\"). " +
            "No caso de execução via arquivo .bat, as aspas não devem ser utilizadas. " +
            "Exemplo: Marcelo Luna, Solange Guedes.";

    public InvalidArgumentException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
