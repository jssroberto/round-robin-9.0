/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.usuariosciabo;

import BOs.UsuariosCiaBO;
import interfaces.IUsuarioCiaBO;

/**
 *
 * @author jl4ma
 */
public class UsuariosCIABO {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        IUsuarioCiaBO user = new UsuariosCiaBO();
        if (user.validacionDatos("00000244978", "MNO97531")) {
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
}
