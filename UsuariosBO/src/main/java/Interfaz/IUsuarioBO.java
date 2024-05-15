/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import dominio.Usuario;
import dtos.UsuarioDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;

/**
 *
 * @author yohan
 */
public interface IUsuarioBO {

    public Usuario consultarUsuario(Usuario usuario);
    
    public UsuarioDTO consultarUsuario(String idCia) throws BOException, PersistenciaException;

    public void persistir(UsuarioDTO usuario);
    
    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos);
}
