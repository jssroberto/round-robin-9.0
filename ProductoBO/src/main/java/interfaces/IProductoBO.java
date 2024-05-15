package interfaces;

import dominio.Producto;
import dtos.ProductoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;

/**
 *
 * @author Roberto García
 */
public interface IProductoBO {

    public void persistir(Producto producto) throws BOException;

    public ProductoDTO consultarProducto(Producto producto) throws BOException;

    public ProductoDTO consultarProducto(Long idProducto) throws BOException;

    public ProductoDTO consultarPorCodigo(String codigoProducto) throws PersistenciaException;

}
