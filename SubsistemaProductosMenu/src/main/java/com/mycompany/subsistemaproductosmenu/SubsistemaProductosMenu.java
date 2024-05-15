/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.subsistemaproductosmenu;

import control.ControlProductos;
import dominio.ProductoCafeteria;
import excepciones.PersitenciaException;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class SubsistemaProductosMenu {

    public static void main(String[] args) throws PersitenciaException {
        
        ControlProductos control = new  ControlProductos();
        
        List<ProductoCafeteria> pros= control.obtenerTodosLosProductos();
        
        for(ProductoCafeteria pro : pros){
            System.out.println(pro.getNombre());
        }
    }
}
