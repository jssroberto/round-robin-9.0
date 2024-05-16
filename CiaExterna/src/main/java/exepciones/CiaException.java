package exepciones;

/**
 * Excepción personalizada para manejar errores específicos del CIA.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class CiaException extends Exception {

    /**
     * Constructor por defecto.
     */
    public CiaException() {
    }

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message El mensaje de error.
     */
    public CiaException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje de error y una causa.
     *
     * @param message El mensaje de error.
     * @param cause La causa del error.
     */
    public CiaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta una causa.
     *
     * @param cause La causa del error.
     */
    public CiaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje de error, una causa, y opciones
     * adicionales.
     *
     * @param message El mensaje de error.
     * @param cause La causa del error.
     * @param enableSuppression Indica si la supresión del excepción está
     * habilitada o no.
     * @param writableStackTrace Indica si el rastreo de pila debe ser escritura
     * o no.
     */
    public CiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
