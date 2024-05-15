package interfaces;

import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public interface IControlProductos {
    
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException;
     public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException;
     public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException;
}
