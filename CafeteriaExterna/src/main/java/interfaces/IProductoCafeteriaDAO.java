package interfaces;

import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define las operaciones permitidas sobre la colección de
 * productos de una cafetería en una base de datos MongoDB.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public interface IProductoCafeteriaDAO {

    /**
     * Actualiza la información de un producto de cafetería en la base de datos.
     *
     * @param productoCafeteria el producto de cafetería a actualizar.
     * @throws CafeteriaException si ocurre un error durante la actualización.
     */
    public void actualizarProducto(ProductoCafeteria productoCafeteria) throws CafeteriaException;

    /**
     * Busca un producto de cafetería por su nombre en la base de datos.
     *
     * @param nombreProducto el nombre del producto de cafetería a buscar.
     * @return el producto de cafetería encontrado.
     * @throws CafeteriaException si ocurre un error durante la búsqueda.
     */
    public ProductoCafeteria buscarProductoCafeteriaPorNombre(String nombreProducto) throws CafeteriaException;

    /**
     * Busca un producto de cafetería por su ID en la base de datos.
     *
     * @param id el ID del producto de cafetería a buscar.
     * @return el producto de cafetería encontrado.
     * @throws CafeteriaException si ocurre un error durante la búsqueda.
     */
    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException;

    /**
     * Obtiene todos los productos de cafetería almacenados en la base de datos.
     *
     * @return una lista de todos los productos de cafetería.
     * @throws CafeteriaException si ocurre un error durante la obtención de los
     * productos.
     */
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException;

    /**
     * Busca productos de cafetería que coincidan con una palabra clave en su
     * nombre o descripción.
     *
     * @param palabra la palabra clave para buscar productos.
     * @return una lista de productos de cafetería que coinciden con la palabra
     * clave.
     * @throws CafeteriaException si ocurre un error durante la búsqueda.
     */
    public List<ProductoCafeteria> consultarProductos(String palabra) throws CafeteriaException;

    /**
     * Obtiene todos los productos de cafetería ordenados alfabéticamente de A a
     * Z.
     *
     * @return una lista de productos de cafetería ordenados alfabéticamente.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosAZ() throws CafeteriaException;

    /**
     * Obtiene todos los productos de cafetería ordenados alfabéticamente de Z a
     * A.
     *
     * @return una lista de productos de cafetería ordenados alfabéticamente en
     * orden descendente.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosZA() throws CafeteriaException;

    /**
     * Obtiene todos los productos de cafetería ordenados por precio de forma
     * ascendente.
     *
     * @return una lista de productos de cafetería ordenados por precio.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosPorPrecio() throws CafeteriaException;

    /**
     * Busca un producto de cafetería por su código en la base de datos.
     *
     * @param codigo el código del producto de cafetería a buscar.
     * @return el producto de cafetería encontrado.
     * @throws CafeteriaException si ocurre un error durante la búsqueda.
     */
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException;

    /**
     * Ordena una lista de productos de cafetería filtrados alfabéticamente de Z
     * a A.
     *
     * @param productos la lista de productos de cafetería a ordenar.
     * @return una lista de productos de cafetería ordenados alfabéticamente en
     * orden descendente.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosFiltradosZA(List<ProductoCafeteria> productos) throws CafeteriaException;

    /**
     * Ordena una lista de productos de cafetería filtrados alfabéticamente de A
     * a Z.
     *
     * @param productos la lista de productos de cafetería a ordenar.
     * @return una lista de productos de cafetería ordenados alfabéticamente en
     * orden ascendente.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosFiltradosAZ(List<ProductoCafeteria> productos) throws CafeteriaException;

    /**
     * Ordena una lista de productos de cafetería filtrados por precio de forma
     * ascendente.
     *
     * @param productos la lista de productos de cafetería a ordenar.
     * @return una lista de productos de cafetería ordenados por precio.
     * @throws CafeteriaException si ocurre un error durante la ordenación.
     */
    public List<ProductoCafeteria> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteria> productos) throws CafeteriaException;
}
