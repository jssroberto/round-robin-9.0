/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import daos.UsuarioCiaDAO;
import exepciones.CiaException;
import interfaces.IUsuarioCiaBO;
import interfaces.IUsuarioCiaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jl4ma
 */
public class UsuariosCiaBO implements IUsuarioCiaBO{
    
    IUsuarioCiaDAO usuario;
    public UsuariosCiaBO(){
        usuario  = new UsuarioCiaDAO();
    }
    
    @Override
    public boolean validacionDatos(String idEstudiante, String contra)  {
        
        try {
            if (usuario.BuscarPersona(idEstudiante, contra)) {
                return true;
            }
        } catch (CiaException ex) {
            Logger.getLogger(UsuariosCiaBO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
}
