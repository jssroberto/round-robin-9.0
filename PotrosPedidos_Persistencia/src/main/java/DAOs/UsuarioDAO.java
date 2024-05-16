/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import IDAOs.IUsuarioDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccionCursos;

    public UsuarioDAO() {
        this.coleccionCursos = Conexion.getDatabase().getCollection("usuarios", Usuario.class);
    }

    @Override
    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos) {
        coleccionCursos.updateOne(Filters.eq("_id", usuario.getId()), Updates.set("saldoPuntos", puntos));
    }

    @Override
    public void persistir(Usuario usuario) {
        coleccionCursos.insertOne(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorId(Usuario usuario) {
        return coleccionCursos.find(Filters.eq("_id", usuario.getId())).first();
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return coleccionCursos.find(Filters.eq("idCia", usuario.getIdCia())).first();
    }

    @Override
    public Usuario consultarUsuario(String idCia) throws PersistenciaException {
        try {
            Usuario usuario = coleccionCursos.find(Filters.eq("idCia", idCia)).first();
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

        coleccionCursos.updateOne(Filters.eq("_id", usuarioId), Updates.push("carrito.productos", nuevoDetalleProducto));
    }

    @Override
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto codigo) {
          UpdateResult result = coleccionCursos.updateOne(Filters.eq("_id", usuarioId), Updates.pull("carrito.productos", codigo));
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
            coleccionCursos.updateOne(Filters.eq("_id", usuario.getId()), Updates.pull("carrito.productos", p));
        }

    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        // Assuming pedido is saved and has an ObjectId assigned
        ObjectId pedidoId = pedido.getId();
        coleccionCursos.updateOne(Filters.eq("_id", usuario.getId()), Updates.push("pedidos", pedidoId));
    }
    
    @Override
    public float actualizarTotalCarrito(Usuario u){
        float total = 0;
        Carrito c;
        for(DetalleProducto a: u.getCarrito().getProductos()){
            total += a.getSubtotal();
        }
        u.getCarrito().setTotalCarrito(total);
        coleccionCursos.updateOne(Filters.eq("_id", u.getId()), Updates.set("carrito", u.getCarrito()));
        return total;
    }

}
