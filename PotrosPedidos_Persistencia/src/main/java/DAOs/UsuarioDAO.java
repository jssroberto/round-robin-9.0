/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import IDAOs.IUsuarioDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccionUsuarios;

    public UsuarioDAO() {
        this.coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios", Usuario.class);
    }

    @Override
    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos) {
        coleccionUsuarios.updateOne(Filters.eq("_id", usuario.getId()), Updates.set("saldoPuntos", puntos));
    }

    @Override
    public void persistir(Usuario usuario) {
        coleccionUsuarios.insertOne(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorId(Usuario usuario) {
        return coleccionUsuarios.find(Filters.eq("_id", usuario.getId())).first();
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return coleccionUsuarios.find(Filters.eq("idCia", usuario.getIdCia())).first();
    }

    @Override
    public Usuario consultarUsuario(String idCia) throws PersistenciaException {
        try {
            Usuario usuario = coleccionUsuarios.find(Filters.eq("idCia", idCia)).first();
            if (usuario == null) {
                throw new PersistenciaException("Usuario no encontrado");
            }
            return usuario;
        } catch (MongoException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void agregarDetalleProductoAlCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto) {

        coleccionUsuarios.updateOne(Filters.eq("_id", usuarioId), Updates.push("carrito.productos", nuevoDetalleProducto));
    }

    @Override
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto codigo) {
          UpdateResult result = coleccionUsuarios.updateOne(Filters.eq("_id", usuarioId), Updates.pull("carrito.productos", codigo));
          if (result.wasAcknowledged()) {
            if (result.getModifiedCount() > 0) {
                System.out.println("");
                System.out.println("La actualización fue exitosa. Se modificaron " + result.getModifiedCount() + " documentos.");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("La actualización no modificó ningún documento.");
                System.out.println("");
            }
        } else {
              System.out.println("");
            System.out.println("La operación de actualización no fue confirmada por el servidor.");
              System.out.println("");
          }
    }

    @Override
    public void vaciarCarrito(Usuario usuario) {
        for (DetalleProducto p: usuario.getCarrito().getProductos()) {
            coleccionUsuarios.updateOne(Filters.eq("_id", usuario.getId()), Updates.pull("carrito.productos", p));
        }

    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        // Assuming pedido is saved and has an ObjectId assigned
        ObjectId pedidoId = pedido.getId();
        coleccionUsuarios.updateOne(Filters.eq("_id", usuario.getId()), Updates.push("pedidos", pedidoId));
    }
    
    @Override
    public float actualizarTotalCarrito(Usuario u){
        float total = 0;
        Carrito c;
        for(DetalleProducto a: u.getCarrito().getProductos()){
            total += a.getSubtotal();
        }
        u.getCarrito().setTotalCarrito(total);
        coleccionUsuarios.updateOne(Filters.eq("_id", u.getId()), Updates.set("carrito", u.getCarrito()));
        return total;
    }
    
    @Override
     public boolean eliminarProductoDelCarrito(String idUsuario, String codigoProducto) throws PersistenciaException {
        try {
            // Crear el filtro para encontrar el usuario por su _id
            Bson filter = Filters.eq("_id", new ObjectId(idUsuario));
            
            // Crear la actualización usando $pull para eliminar el producto específico del arreglo productos
            Bson update = Updates.pull("carrito.productos", Filters.eq("codigoProducto", codigoProducto));

            // Realizar la actualización
            UpdateResult result = coleccionUsuarios.updateOne(filter, update);
            
            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado");
            }
            if (result.getModifiedCount() == 0) {
                throw new PersistenciaException("El producto no se encontró en el carrito");
            }
            return true;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al eliminar producto del carrito", e);
        }
    }
    

}
