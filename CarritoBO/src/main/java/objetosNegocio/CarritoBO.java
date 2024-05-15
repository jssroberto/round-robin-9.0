/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;


import DAOs.ProductoDAO;
import DAOs.UsuarioDAO;
import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import excepciones.PersistenciaException;
import interfaces.ICarritoBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;


/**
 *
 * @author yohan
 */
public class CarritoBO implements ICarritoBO{

    UsuarioDAO carrito;
    ProductoDAO producto;
    

    public CarritoBO(){
        carrito = new UsuarioDAO();
        producto = new ProductoDAO();
    }
    
   

    @Override
    public void agregarCarrito(Usuario usuarioId, Producto product, int cantidad){
        conexion.Conexion.getDatabase();
        Producto pro = null;
        try {
            pro = producto.consultar(product);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CarritoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        float subtotal = cantidad* pro.getPrecio();
        DetalleProducto detalle = new DetalleProducto();
        detalle.setCantidad(cantidad);
        detalle.setCodigoProducto(pro.getCodigoProducto());
        detalle.setDireccionImagen(pro.getDireccionImagen());
        detalle.setNombre(pro.getNombre());
        detalle.setSubtotal(subtotal);
        detalle.setPrecio(pro.getPrecio());
        detalle.setPuntosCuesta(pro.getPuntosCuesta());
        detalle.setPuntosGenera(pro.getPuntosGenera());
        ObjectId o = carrito.consultarUsuario(usuarioId).getId();
        carrito.agregarDetalleProductoAlCarrito(o, detalle);
        conexion.Conexion.close();
    }
    
    @Override
    public void vaciarCarrito(Usuario user){
        carrito.vaciarCarrito(user);
    }
    
    @Override
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto){
        carrito.eliminarProductoCarrito(usuarioId, nuevoDetalleProducto);
    }
    
    
    
}
