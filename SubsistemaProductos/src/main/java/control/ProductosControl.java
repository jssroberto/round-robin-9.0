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
//        conexion.Conexion.getDatabase();
        IProductoBO productosControl = new ProductoBO();
        ProductoDTO a =  productosControl.consultarPorCodigo(codigoProducto);
//        conexion.Conexion.close();
        return a;
        
    }

}
