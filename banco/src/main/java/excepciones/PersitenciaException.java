/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author jl4ma
 */
public class PersitenciaException extends Exception{

    public PersitenciaException() {
    }

    public PersitenciaException(String message) {
        super(message);
    }

    public PersitenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
