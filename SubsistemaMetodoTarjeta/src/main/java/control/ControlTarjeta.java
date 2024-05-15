/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import excepciones.PersitenciaException;
import interfaces.IControlTarjeta;
import metodos.ValidarCompraTarjeta;
import metodos.ValidarDatosTarjetas;

/**
 *
 * @author jl4ma
 */
public class ControlTarjeta implements IControlTarjeta{
    
    ValidarCompraTarjeta compra;
    ValidarDatosTarjetas datos;
    
    public ControlTarjeta(){
        compra = new ValidarCompraTarjeta();
        datos = new ValidarDatosTarjetas();
    }
    
    @Override
    public boolean validarDatos(String numeroTarjeta) throws PersitenciaException{
        
        if (datos.validarDatos(numeroTarjeta)) {
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean validacionCompra(String num, float total){
        return compra.validacionCompra(num, total);
    }
}
