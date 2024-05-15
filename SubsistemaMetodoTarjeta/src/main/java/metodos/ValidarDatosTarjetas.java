/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import BOs.ValidarTarjeta;
import dominio.Tarjeta;
import excepciones.BancoException;
import interfaces.IValidarTarjetaBO;
import javax.swing.JOptionPane;

/**
 *
 * @author jl4ma
 */
public class ValidarDatosTarjetas {

    IValidarTarjetaBO tarjetas;

    public ValidarDatosTarjetas() {
        tarjetas = new ValidarTarjeta();
    }

    public boolean validarDatos(Tarjeta tarjeta) throws BancoException {
        try {

            Tarjeta tar = tarjetas.validarDatos(tarjeta);
            if(tar==null){
                throw new BancoException("Credenciales no válidas");
            }else{
                return true;
            }

        } catch (BancoException e) {
            throw new BancoException(e.getMessage());
        }
    }
}
