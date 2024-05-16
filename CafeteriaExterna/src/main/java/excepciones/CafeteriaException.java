package excepciones;

/**
 * Excepción personalizada para manejar errores específicos relacionados con
 * operaciones en la cafetería.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class CafeteriaException extends Exception {

    /**
     * Crea una nueva excepción sin un mensaje específico.
     */
    public CafeteriaException() {
    }

    /**
     * Crea una nueva excepción con el mensaje especificado.
     *
     * @param message el mensaje de la excepción.
     */
    public CafeteriaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva excepción con el mensaje y la causa especificados.
     *
     * @param message el mensaje de la excepción.
     * @param cause la causa de la excepción.
     */
    public CafeteriaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva excepción con la causa especificada.
     *
     * @param cause la causa de la excepción.
     */
    public CafeteriaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva excepción con el mensaje, la causa, la capacidad de
     * supresión y la capacidad de escritura de traza especificados.
     *
     * @param message el mensaje de la excepción.
     * @param cause la causa de la excepción.
     * @param enableSuppression indica si la supresión está habilitada o no.
     * @param writableStackTrace indica si la traza de pila debe ser escribible
     * o no.
     */
    public CafeteriaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
