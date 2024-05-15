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


    public ProductoCafeteriaBO() {

    }

    @Override
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException {
        IProductoCafeteriaDAO cafeteria = new ProductoCafeteriaDAO();
        List<ProductoCafeteria> productos;

        productos = cafeteria.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            throw new CafeteriaException("No existe ningún producto registrado");
        } else {
            return productos;
        }
    }

    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException {
        IProductoCafeteriaDAO cafeteria = new ProductoCafeteriaDAO();

        ProductoCafeteria pro;

        pro = cafeteria.buscarProductoCafeteriaPorID(id);

        if (pro == null) {
            throw new CafeteriaException("producto no encontrado");
        } else {
            return pro;
        }
    }

    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException {
        IProductoCafeteriaDAO cafeteria = new ProductoCafeteriaDAO();

        return cafeteria.consultarProductosPorCodigo(codigo);
    }
}
