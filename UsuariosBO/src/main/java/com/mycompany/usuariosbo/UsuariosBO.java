/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.usuariosbo;

import BOs.UsuarioBO;
import Interfaz.IUsuarioBO;
import dtos.UsuarioDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yohan
 */
public class UsuariosBO {

    public static void main(String[] args) {
        try {
            IUsuarioBO usuarioBO = new UsuarioBO();
            UsuarioDTO usuarioDTO = usuarioBO.consultarUsuario("00000011211");
            System.out.println(usuarioDTO);
        } catch (BOException | PersistenciaException ex) {
            Logger.getLogger(UsuariosBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
