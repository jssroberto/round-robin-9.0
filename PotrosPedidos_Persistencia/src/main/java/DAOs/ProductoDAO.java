/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import IDAOs.IProductoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import excepciones.PersistenciaException;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class ProductoDAO implements IProductoDAO {

    private final MongoCollection<Producto> coleccionProductos;

    public ProductoDAO() {
        this.coleccionProductos = Conexion.getDatabase().getCollection("productos", Producto.class);
    }

    @Override
    public void persistir(Producto producto) throws PersistenciaException {
            coleccionProductos.insertOne(producto);
            
    }

    @Override
    public Producto consultar(Producto pro) throws PersistenciaException {
        
        try {
            Producto producto = coleccionProductos.find(Filters.eq("codigoProducto", pro.getCodigoProducto())).first();
            if (producto == null) {
                throw new PersistenciaException("Producto no encontrado");
            }
            return producto;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el producto", e);
        }
    }


    @Override
    public Producto consultarPorCodigo(String codigoProducto) throws PersistenciaException {
        try {
            Producto producto = coleccionProductos.find(Filters.eq("codigoProducto", codigoProducto)).first();
            if (producto == null) {
                throw new PersistenciaException("Producto no encontrado");
            }
            return producto;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el producto", e);
        }
    }
    
    @Override
    public Producto consultar(Long idProducto) throws PersistenciaException {
        try {
            Producto producto = coleccionProductos.find(Filters.eq("idProducto", idProducto)).first();
            if (producto == null) {
                throw new PersistenciaException("Producto no encontrado");
            }
            return producto;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el producto", e);

        }

    }
}
