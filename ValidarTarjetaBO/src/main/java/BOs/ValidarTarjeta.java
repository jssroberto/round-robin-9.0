/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import daos.TarjetaDAO;
import dominio.Tarjeta;
import excepciones.BancoException;
import idaos.ITarjetaDAO;
import interfaces.IValidarTarjetaBO;

/**
 *
 * @author jl4ma
 */
public class ValidarTarjeta implements IValidarTarjetaBO {


    public ValidarTarjeta() {
    }

    @Override
    public Tarjeta validarDatos(Tarjeta tarjeta) throws BancoException {
        ITarjetaDAO tarjetas = new TarjetaDAO();
        Tarjeta tar = tarjetas.consultarTarjetaMongo(tarjeta);
        if(tar ==null){
            throw new BancoException("Tarjeta no enonctrada");
        }else{
            return tar;
        }
            
    }

}
