/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.Tarjeta;
import excepciones.BancoException;
import interfaces.IControlTarjeta;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public boolean validarDatos(Tarjeta tar) throws BancoException{
        conexion.ConexionBanco.getDatabase();
        if (datos.validarDatos(tar)) {
            conexion.ConexionBanco.close();
            return true;
        }else{
            conexion.ConexionBanco.close();
            return false;
        }
    }
    
    @Override
    public boolean validacionCompra(Tarjeta tar, float total){
        conexion.ConexionBanco.getDatabase();
        try {
            if (compra.validacionCompra(tar, total)) {
                conexion.ConexionBanco.close();
              return true;  
            }else{
                conexion.ConexionBanco.close();
                throw new BancoException("Saldo Insuficiente");
            }
        } catch (BancoException ex) {
            Logger.getLogger(ControlTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            conexion.ConexionBanco.close();
            return false;
        }
    }
}
