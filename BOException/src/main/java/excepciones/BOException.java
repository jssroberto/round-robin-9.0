package excepciones;

/**
 * Excepción personalizada para manejo de excepciones en la lógica de negocio
 * (BO).
 */
public class BOException extends Exception {

    /**
     * Crea una nueva instancia de BOException sin mensaje detallado.
     */
    public BOException() {
    }

    /**
     * Crea una nueva instancia de BOException con un //mensaje detallado.
     *
     * @param message El mensaje que describe el error.
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de BOException con un mensaje detallado y la
     * causa.
     *
     * @param message El mensaje que describe el error.
     * @param cause La causa que originó esta excepción.
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de BOException con la causa.
     *
     * @param cause La causa que originó esta excepción.
     */
    public BOException(Throwable cause) {
        super(cause);
    }
}
