/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuariosCiaBO;
import interfaces.IControlLogin;
import interfaces.IUsuarioCiaBO;
import metodos.IniciarSesion;

/**
 *
 * @author jl4ma
 */
public class ControlLogin implements IControlLogin{
    IUsuarioCiaBO inicio;
    
    public ControlLogin(){
        inicio = new UsuariosCiaBO();
    }
    
    @Override
    public boolean validacionDatos(String idEstudiante, String contra) throws Exception{
        conexion.ConexionCia.getDatabase();
        if (inicio.validacionDatos(idEstudiante, contra)) {
            conexion.ConexionCia.close();
            return true;
        }else{
            conexion.ConexionCia.close();
            return false;
        }
    }
}
