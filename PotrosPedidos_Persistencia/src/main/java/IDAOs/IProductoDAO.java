package IDAOs;

import dominio.Producto;
import excepciones.PersistenciaException;

/**
 *
 * @author Roberto García
 */
public interface IProductoDAO {

    public void persistir(Producto producto) throws PersistenciaException;

    public Producto consultar(Producto producto) throws PersistenciaException;

    public Producto consultar(Long idProducto) throws PersistenciaException;

    public Producto consultarPorCodigo(String codigoProducto) throws PersistenciaException;
}
