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
import conexion.Conexion;
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
    public void eliminarProductoCarrito(ObjectId usuarioId, DetalleProducto nuevoDetalleProducto) {
        
        coleccionCursos.updateOne(Filters.eq("_id", usuarioId), Updates.pull("carrito.productos", nuevoDetalleProducto));
    }

    @Override
    public void vaciarCarrito(Usuario usuario) {
        for (int i = 0; i < usuario.getCarrito().getProductos().size(); i++) {
            this.eliminarProductoCarrito(usuario.getId(), usuario.getCarrito().getProductos().get(i));
        }

    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        // Assuming pedido is saved and has an ObjectId assigned
        ObjectId pedidoId = pedido.getId();
        coleccionCursos.updateOne(Filters.eq("_id", usuario.getId()), Updates.push("pedidos", pedidoId));
    }

}
