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
public class ValidarCompraTarjeta {
    
    IValidarTarjetaBO tarjeta;
    public ValidarCompraTarjeta(){
        tarjeta = new ValidarTarjeta();
    }
    
    public boolean validacionCompra(Tarjeta num, float total) throws BancoException{
        
        Tarjeta tar = tarjeta.validarDatos(num);
        float saldo = tar.getSaldo()-total;
        if (saldo >=0) {
            tarjeta.actualizarSaldo(tar, saldo);
            return true;
        }else{
            throw new BancoException("Saldo insuficiente");
        }
        
    }
}
