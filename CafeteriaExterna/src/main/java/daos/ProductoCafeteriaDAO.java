package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionCafeteria;
import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import interfaces.IProductoCafeteriaDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que implementa la interfaz IProductoCafeteriaDAO para realizar
 * operaciones sobre la colección de productos de una cafetería en una base de
 * datos MongoDB.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class ProductoCafeteriaDAO implements IProductoCafeteriaDAO {

    private final MongoCollection<ProductoCafeteria> coleccionCafeteria;

    /**
     * Constructor que inicializa la colección de productos desde la base de
     * datos.
     */
    public ProductoCafeteriaDAO() {
        this.coleccionCafeteria = ConexionCafeteria.getDatabase().getCollection("cafeteria", ProductoCafeteria.class);
    }

    @Override
    public void actualizarProducto(ProductoCafeteria productoCafeteria) throws CafeteriaException {
        if (productoCafeteria.getId() == null) {
            throw new CafeteriaException("El ID del producto no puede ser nulo.");
        }
        coleccionCafeteria.replaceOne(Filters.eq("_id", productoCafeteria.getId()), productoCafeteria);
    }

    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorNombre(String nombreProducto) throws CafeteriaException {
        return coleccionCafeteria.find(Filters.eq("nombre", nombreProducto)).first();
    }

    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException {
        return coleccionCafeteria.find(Filters.eq("_id", id)).first();
    }

    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException {
        return coleccionCafeteria.find(Filters.eq("codigo", codigo)).first();
    }

    @Override
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException {
        return coleccionCafeteria.find().into(new ArrayList<>());
    }

    @Override
    public List<ProductoCafeteria> consultarProductos(String palabra) throws CafeteriaException {
        return coleccionCafeteria.find(Filters.or(
                Filters.regex("nombre", palabra, "i"),
                Filters.regex("descripcion", palabra, "i")
        )).into(new ArrayList<>());
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosAZ() throws CafeteriaException {
        try {
            List<ProductoCafeteria> productos = obtenerTodosLosProductos();
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre));
            return productos;
        } catch (CafeteriaException e) {
            throw new CafeteriaException("Error al ordenar productos de forma ascendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosZA() throws CafeteriaException {
        try {
            List<ProductoCafeteria> productos = obtenerTodosLosProductos();
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre).reversed());
            return productos;
        } catch (CafeteriaException e) {
            throw new CafeteriaException("Error al ordenar productos de forma descendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosPorPrecio() throws CafeteriaException {
        try {
            List<ProductoCafeteria> productos = obtenerTodosLosProductos();
            productos.sort(Comparator.comparingDouble(ProductoCafeteria::getPrecio));
            return productos;
        } catch (CafeteriaException e) {
            throw new CafeteriaException("Error al ordenar productos por precio", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosAZ(List<ProductoCafeteria> productos) throws CafeteriaException {
        try {
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre));
            return productos;
        } catch (Exception e) {
            throw new CafeteriaException("Error al ordenar productos filtrados de forma ascendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosZA(List<ProductoCafeteria> productos) throws CafeteriaException {
        try {
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre).reversed());
            return productos;
        } catch (Exception e) {
            throw new CafeteriaException("Error al ordenar productos filtrados de forma descendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteria> productos) throws CafeteriaException {
        try {
            productos.sort(Comparator.comparingDouble(ProductoCafeteria::getPrecio));
            return productos;
        } catch (Exception e) {
            throw new CafeteriaException("Error al ordenar productos filtrados por precio", e);
        }
    }

}
