/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;


import DAOs.ProductoDAO;
import DAOs.UsuarioDAO;
import IDAOs.IProductoDAO;
import IDAOs.IUsuarioDAO;
import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import excepciones.PersistenciaException;
import interfaces.ICarritoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;


/**
 *
 * @author yohan
 */
public class CarritoBO implements ICarritoBO{

    

    public CarritoBO(){
       
    }
    

    @Override
    public void agregarCarrito(Usuario usuarioId, Producto product, int cantidad){
        IProductoDAO producto = new ProductoDAO();
        IUsuarioDAO carrito = new UsuarioDAO();
        Producto pro = null;
        boolean entrarRecorrido = false;
        float subtotal;
        try {
            pro = producto.consultar(product);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CarritoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        subtotal = cantidad* pro.getPrecio();
        DetalleProducto detalle = new DetalleProducto();
        detalle.setCantidad(cantidad);
        detalle.setCodigoProducto(pro.getCodigoProducto());
        detalle.setDireccionImagen(pro.getDireccionImagen());
        detalle.setNombre(pro.getNombre());
        detalle.setSubtotal(subtotal);
        detalle.setPrecio(pro.getPrecio());
        detalle.setPuntosCuesta(pro.getPuntosCuesta());
        detalle.setPuntosGenera(pro.getPuntosGenera());
        Usuario o = carrito.consultarUsuario(usuarioId);
        List<DetalleProducto> produ = o.getCarrito().getProductos();
        if(produ.isEmpty()){
            carrito.agregarDetalleProductoAlCarrito(o.getId(), detalle);
        }else{
            for(DetalleProducto z: produ){
                if(z.getCodigoProducto().equals(pro.getCodigoProducto())){
                    carrito.eliminarProductoCarrito(o.getId(), z);
                    detalle.setCantidad(z.getCantidad()+cantidad);
                    subtotal = detalle.getCantidad()* z.getPrecio();
                    detalle.setSubtotal(subtotal);
                    carrito.agregarDetalleProductoAlCarrito(o.getId(), detalle);
                    entrarRecorrido = true;
                }
            }
            if(!entrarRecorrido){
                carrito.agregarDetalleProductoAlCarrito(o.getId(), detalle);
            }
        }
        
    }
    
    @Override
    public void vaciarCarrito(Usuario user){
        IUsuarioDAO carrito = new UsuarioDAO();
        carrito.vaciarCarrito(user);
    }
    
    @Override
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto){
        IUsuarioDAO carrito = new UsuarioDAO();
        carrito.eliminarProductoCarrito(usuarioId, nuevoDetalleProducto);
    }
    
    @Override
    public float actualizarTotalCarrito(Usuario u){
        IUsuarioDAO carrito = new UsuarioDAO();
        return carrito.actualizarTotalCarrito(u);
    }
    
    
    
}
