/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.validartarjetabo;

import BOs.ValidarTarjeta;
import excepciones.PersitenciaException;
import interfaces.IValidarTarjetaBO;

/**
 *
 * @author jl4ma
 */
public class asas {

    public static void main(String[] args) throws PersitenciaException {
        System.out.println("Hello World!");
        IValidarTarjetaBO tar = new ValidarTarjeta();
        
        if(tar.validarDatos("4696-6542-7464-6464")){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
}
