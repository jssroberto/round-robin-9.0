package interfaces;

import dtos.ProductoDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author Roberto García
 */
public interface IProductosControl {

    public ProductoDTO consultarPorCodigo(String codigoProducto) throws PersistenciaException;
}
