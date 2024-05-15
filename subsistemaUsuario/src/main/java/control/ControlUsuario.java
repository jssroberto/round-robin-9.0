/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuarioBO;
import Interfaz.IUsuarioBO;
import dominio.Usuario;
import dtos.UsuarioDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import interfaces.IControlUsuario;

/**
 *
 * @author jl4ma
 */
public class ControlUsuario implements IControlUsuario {

    IUsuarioBO user;

    public ControlUsuario() {
        user = new UsuarioBO();
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return user.consultarUsuario(usuario);
    }

    /**
     *
     * @param idCia
     * @return
     * @throws PersistenciaException
     * @throws BOException
     */
    @Override
    public UsuarioDTO consultarUsuarioPorId(String idCia) throws PersistenciaException, BOException{
        IUsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDTO usuarioDTO = usuarioBO.consultarUsuario(idCia);
        return usuarioDTO;
    }

}
