/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.subsistemainiciarsesion;

import control.ControlLogin;
import interfaces.IControlLogin;

/**
 *
 * @author jl4ma
 */
public class SubsistemaIniciarSesion {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        IControlLogin control = new ControlLogin();
        if (control.validacionDatos("00000011211", "ABC12345")) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
    }
}
