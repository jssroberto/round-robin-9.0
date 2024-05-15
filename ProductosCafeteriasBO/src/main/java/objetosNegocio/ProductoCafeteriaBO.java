/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import daos.ProductoCafeteriaDAO;
import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import interfaces.IProductoCafeteriaBO;
import interfaces.IProductoCafeteriaDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class ProductoCafeteriaBO implements IProductoCafeteriaBO {

    IProductoCafeteriaDAO cafeteria;
  
    public ProductoCafeteriaBO() {
        this.cafeteria = new ProductoCafeteriaDAO();

    }

    @Override
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException {
        List<ProductoCafeteria> productos;

        productos = cafeteria.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            throw new CafeteriaException("lista vacia");
        } else {
            return productos;
        }
    }

    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException {
        ProductoCafeteria pro;
        
        pro = cafeteria.buscarProductoCafeteriaPorID(id);
        
        if(pro == null){
            throw new CafeteriaException("producto no encontrado");
        } else {
            return pro;
        }
    }
    
    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException{
        return cafeteria.consultarProductosPorCodigo(codigo);
    }
}
