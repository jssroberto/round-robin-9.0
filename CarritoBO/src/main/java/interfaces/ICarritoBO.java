/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author yohan
 */
public interface ICarritoBO {

    public void agregarCarrito(Usuario usuarioId, Producto codigoProducto, int cantidad);
    public void vaciarCarrito(Usuario user);
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto);
    public float actualizarTotalCarrito(Usuario u);
}
