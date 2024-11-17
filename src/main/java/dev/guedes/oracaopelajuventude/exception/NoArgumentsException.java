package main.java.dev.guedes.oracaopelajuventude.exception;

/**
 * Custom exception thrown when no arguments (names list) are provided.
 * Extends IllegalArgumentException to indicate that the argument passed to a method is invalid or missing.
 *
 * @author João Guedes
 */
public class NoArgumentsException extends IllegalArgumentException {

    private static final String DEFAULT_ERROR_MESSAGE =
            "É necessário fornecer uma lista de nomes, " +
            "separados por vírgula. Exemplo: " +
            "\"Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay\" quando executado via CLI, " +
            "onde as aspas são obrigatórias. " +
            "Se estiver executando pelo arquivo .bat, não use aspas, por exemplo: " +
            "Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay." +
            " Nomes compostos são aceitos e devem ser separados por vírgula.";

    public NoArgumentsException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
