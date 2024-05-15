/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cia;

import DAOs.UsuarioCiaDAO;
import Incersiones.InsercionMasivaUsuariosCIA;

/**
 *
 * @author jl4ma
 */
public class Cia {

    public static void main(String[] args) throws Exception {
//        System.out.println("Hello World!");
//        InsercionMasivaUsuariosCIA i = new InsercionMasivaUsuariosCIA();
//        if (!i.datosExisten()) {
//            i.insertarRegistros();
//        };
        UsuarioCiaDAO user = new UsuarioCiaDAO();
        if (user.BuscarPersona("00000244978", "MNO97531")) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }

    }
}
