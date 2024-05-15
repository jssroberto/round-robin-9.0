/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import IDAOs.IPedidoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import conexion.Conexion;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class PedidoDAO implements IPedidoDAO {

    private final MongoCollection<Pedido> coleccionPedido;
    private final MongoCollection<Usuario> coleccionUsuarios;

    public PedidoDAO() {
        this.coleccionPedido = Conexion.getDatabase().getCollection("pedidos", Pedido.class);
        this.coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios", Usuario.class);
    }

    @Override
    public void persistir(Pedido pedido) throws PersistenciaException {
        conexion.Conexion.getDatabase();
        try {
            coleccionPedido.insertOne(pedido);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al persistir pedido", e);
        }
    }

    @Override
    public Pedido consultar(Pedido etiquetaPedido) throws PersistenciaException {
        return coleccionPedido.find(Filters.eq("etiquetaPedido", etiquetaPedido.getEtiquetaPedido())).first();
    }

    @Override
    public List<Pedido> consultarPedidos(String idUsuario) throws PersistenciaException {
        try {
            List<Pedido> pedidos = new ArrayList<>();

            // Create the pipeline for the aggregation
            List<Bson> pipeline = Arrays.asList(
                    Aggregates.match(Filters.eq("_id", new ObjectId(idUsuario))), // Match the user by id
                    Aggregates.lookup("pedidos", "pedidos", "_id", "pedidos"), // Lookup to join with pedidos
                    Aggregates.unwind("$pedidos"), // Unwind the pedidos array
                    Aggregates.replaceRoot("$pedidos") // Replace the root with the pedido document
            );

            // Perform the aggregation
            coleccionUsuarios.aggregate(pipeline, Pedido.class).into(pedidos);

            return pedidos;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar pedidos", e);
        }
    }

    @Override
    public Pedido consultarPorId(String id) throws PersistenciaException {
        try {
            ObjectId objectId = new ObjectId(id);
            Pedido pedido = coleccionPedido.find(Filters.eq("_id", objectId)).first();
            if (pedido != null) {
                return pedido;
            } else {
                throw new PersistenciaException("No se encontró el pedido con el ID proporcionado.");
            }
        } catch (IllegalArgumentException e) {
            throw new PersistenciaException("El ID proporcionado no es válido.", e);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el pedido", e);
        }
    }

    @Override
    public List<DetalleProducto> consultarDetalleProductosPorIdPedido(String idPedido) throws PersistenciaException {
        try {
            ObjectId objectId = new ObjectId(idPedido);
            Pedido pedido = coleccionPedido.find(Filters.eq("_id", objectId)).first();
            if (pedido != null) {
                return pedido.getDetalleProductos();
            } else {
                throw new PersistenciaException("No se encontró el pedido con el ID proporcionado.");
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar detalle de productos por ID de pedido", e);
        } catch (IllegalArgumentException e) {
            throw new PersistenciaException("ID de pedido inválido", e);
        }
    }
}
