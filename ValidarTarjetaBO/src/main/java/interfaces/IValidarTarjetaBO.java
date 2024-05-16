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
public interface IValidarTarjetaBO {
    
    public Tarjeta validarDatos(Tarjeta tarjeta) throws BancoException;
    public void actualizarSaldo(Tarjeta tar, float saldo);


}

