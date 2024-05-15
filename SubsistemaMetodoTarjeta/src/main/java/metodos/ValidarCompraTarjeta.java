/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import BOs.ValidarTarjeta;
import dominio.Tarjeta;
import interfaces.IValidarTarjetaBO;
import javax.persistence.PersistenceException;
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
    
    public boolean validacionCompra(String num, float total){
        
        Tarjeta tar = tarjeta.consultar(num);
        float saldo = tar.getSaldo()-total;
        
        if (saldo >=0) {
            return true;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        
    }
}
