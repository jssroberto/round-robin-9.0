/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import BOs.UsuariosCiaBO;
import interfaces.IUsuarioCiaBO;
import javax.swing.JOptionPane;

/**
 *
 * @author jl4ma
 */
public class IniciarSesion {
    
    IUsuarioCiaBO usuario;
    public IniciarSesion(){
        usuario = new UsuariosCiaBO();
    }
    
    public boolean validacionDatos(String idEstudiante, String contra) throws Exception{
        if(usuario.validacionDatos(idEstudiante, contra)){
//            JOptionPane.showMessageDialog(null, "Bienvenido");
            return true;
        }else{
//            JOptionPane.showMessageDialog(null, "Credenciales no válidas");
            return false;
        }
    }
}
