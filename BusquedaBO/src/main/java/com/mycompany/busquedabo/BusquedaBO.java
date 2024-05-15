/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.busquedabo;

import Interfaz.IBusquedaBO;
 import dtos.ProductoCafeteriaDTO;
import excepciones.PersitenciaException;

import java.util.List;

/**
 *
 * @author yohan
 */
public class BusquedaBO {

    public static void main(String[] args)  throws PersitenciaException{
        System.out.println("Hello World!");
        IBusquedaBO b = new BOs.BusquedaBO();
     
        List<ProductoCafeteriaDTO> pa = b.consultarProductos("h");

        for (ProductoCafeteriaDTO prrr : pa) {
            System.out.println(prrr.getNombre());
        }
    }
}

