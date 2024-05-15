/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import BOs.ValidarTarjeta;
import excepciones.PersitenciaException;
import interfaces.IValidarTarjetaBO;
import javax.swing.JOptionPane;

/**
 *
 * @author jl4ma
 */
public class ValidarDatosTarjetas {

    IValidarTarjetaBO tarjeta;

    public ValidarDatosTarjetas() {
        tarjeta = new ValidarTarjeta();
    }

    public boolean validarDatos(String numeroTarjeta) throws PersitenciaException {
        try {

            return tarjeta.validarDatos(numeroTarjeta);

        } catch (PersitenciaException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
