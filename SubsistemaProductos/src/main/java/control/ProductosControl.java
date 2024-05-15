package control;

import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import interfaces.IProductoBO;
import interfaces.IProductosControl;
import objetosNegocio.ProductoBO;

/**
 *
 * @author Roberto García
 */
public class ProductosControl implements IProductosControl {

    @Override
    public ProductoDTO consultarPorCodigo(String codigoProducto) throws PersistenciaException {
        IProductoBO productosControl = new ProductoBO();
        return productosControl.consultarPorCodigo(codigoProducto);
        
    }

}
