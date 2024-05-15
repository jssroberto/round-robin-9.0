/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.TarjetaDAO;
import dominio.Tarjeta;
import excepciones.PersitenciaException;
import interfaces.ITarejaDAO;
import interfaces.IValidarTarjetaBO;

/**
 *
 * @author jl4ma
 */
public class ValidarTarjeta implements IValidarTarjetaBO{
    
   ITarejaDAO tarjeta; 
   public ValidarTarjeta(){
       tarjeta=new TarjetaDAO();
   }
   @Override
   public boolean validarDatos(String numeroTarjeta) throws PersitenciaException{
       
       if (tarjeta.consultarTarjeta(numeroTarjeta)!=null) {
           return true;
       }else{
           throw new PersitenciaException("Tarjeta no encontrada");
       }
   }
   
   @Override
   public Tarjeta consultar(String num){
       return tarjeta.consultarTarjeta(num);
   }
}
