/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.IControlLogin;
import metodos.IniciarSesion;

/**
 *
 * @author jl4ma
 */
public class ControlLogin implements IControlLogin{
    IniciarSesion inicio;
    
    public ControlLogin(){
        inicio = new IniciarSesion();
    }
    
    @Override
    public boolean validacionDatos(String idEstudiante, String contra) throws Exception{
        if (inicio.validacionDatos(idEstudiante, contra)) {
            return true;
        }else{
            return false;
        }
    }
}
