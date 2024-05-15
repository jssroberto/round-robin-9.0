/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Tarjeta;
import excepciones.BancoException;


/**
 *
 * @author jl4ma
 */
public interface IControlTarjeta {
    
    public boolean validarDatos(Tarjeta tar) throws BancoException;
    public boolean validacionCompra(Tarjeta tar, float total);
}
