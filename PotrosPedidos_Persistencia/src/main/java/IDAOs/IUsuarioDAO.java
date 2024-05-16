/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IUsuarioDAO {

    public void persistir(dominio.Usuario usuario);

    public dominio.Usuario consultarUsuario(dominio.Usuario usuario);

    public Usuario consultarUsuario(String idCia) throws PersistenciaException;

    public void agregarDetalleProductoAlCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto);

    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto);

    public void vaciarCarrito(dominio.Usuario usuario);

    public void referenciarPedido(dominio.Usuario usuario, Pedido pedido);

    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos);

    public Usuario consultarUsuarioPorId(Usuario usuario);
    public float actualizarTotalCarrito(Usuario u);
}
