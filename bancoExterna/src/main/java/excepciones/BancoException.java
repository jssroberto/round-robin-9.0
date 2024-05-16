package excepciones;

/**
 * Excepción personalizada para manejar errores específicos del banco. Extiende
 * la clase Exception estándar de Java.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class BancoException extends Exception {

    /**
     * Constructor por defecto.
     */
    public BancoException() {
    }

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message el mensaje de error.
     */
    public BancoException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y una causa subyacente.
     *
     * @param message el mensaje de error.
     * @param cause la causa subyacente.
     */
    public BancoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa subyacente.
     *
     * @param cause la causa subyacente.
     */
    public BancoException(Throwable cause) {
        super(cause);
    }
}
