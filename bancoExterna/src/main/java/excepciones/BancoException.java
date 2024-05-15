package excepciones;

/**
 *
 * @author Roberto García
 */
public class BancoException extends Exception {

    public BancoException() {
    }

    public BancoException(String message) {
        super(message);
    }

    public BancoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BancoException(Throwable cause) {
        super(cause);
    }

}
