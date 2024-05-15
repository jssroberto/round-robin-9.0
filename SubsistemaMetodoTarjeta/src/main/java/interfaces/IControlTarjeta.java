/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersitenciaException;

/**
 *
 * @author jl4ma
 */
public interface IControlTarjeta {
    
    public boolean validarDatos(String numeroTarjeta) throws PersitenciaException;
    public boolean validacionCompra(String num, float total);
}
