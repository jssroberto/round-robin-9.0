/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cafeteria;

import Incerciones.InsercionMasivaProductosCafeteriaBO;

/**
 *
 * @author yohan
 */
public class cafe {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        InsercionMasivaProductosCafeteriaBO inser = new InsercionMasivaProductosCafeteriaBO();
        
        inser.insertarRegistros();
    }
}
