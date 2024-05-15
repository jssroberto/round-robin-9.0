/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public interface IProductoCafeteriaDAO {
    
    public void actualizarProducto(ProductoCafeteria productoCafeteria) throws CafeteriaException;

    public ProductoCafeteria buscarProductoCafeteriaPorNombre(String nombreProducto) throws CafeteriaException;

    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException;

    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException;

    public List<ProductoCafeteria> consultarProductos(String palabra) throws CafeteriaException;

    public List<ProductoCafeteria> ordenarProductosAZ() throws CafeteriaException;

    public List<ProductoCafeteria> ordenarProductosZA() throws CafeteriaException;

    public List<ProductoCafeteria> ordenarProductosPorPrecio() throws CafeteriaException;

    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException;


    public List<ProductoCafeteria> ordenarProductosFiltradosZA(List<ProductoCafeteria> productos) throws CafeteriaException;

    public List<ProductoCafeteria> ordenarProductosFiltradosAZ(List<ProductoCafeteria> productos) throws CafeteriaException;

    public List<ProductoCafeteria> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteria> productos) throws CafeteriaException;
}
