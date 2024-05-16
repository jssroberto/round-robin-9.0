/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Usuario;
import dtos.UsuarioDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;

/**
 *
 * @author jl4ma
 */
public interface IControlUsuario {

    public Usuario consultarUsuario(Usuario usuario);

    public UsuarioDTO consultarUsuarioPorId(String idCia) throws PersistenciaException, BOException;

    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos);

    public boolean eliminarProductoDelCarrito(String idUsuario, String codigoProducto) throws PersistenciaException;
}
