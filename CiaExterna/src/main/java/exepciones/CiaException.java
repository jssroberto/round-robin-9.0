/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author jl4ma
 */
public class CiaException extends Exception{

    public CiaException() {
    }

    public CiaException(String message) {
        super(message);
    }

    public CiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CiaException(Throwable cause) {
        super(cause);
    }

    public CiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
