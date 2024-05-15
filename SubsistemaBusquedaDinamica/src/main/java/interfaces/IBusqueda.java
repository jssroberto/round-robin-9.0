/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.ProductoCafeteriaDTO;
import excepciones.CafeteriaException;
import java.util.List;

/**
 *
 * @author yohan
 */
public interface IBusqueda {

    public List<ProductoCafeteriaDTO> consultarProductos(String palabra) throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosAZ() throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosZA() throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosPorPrecio() throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteriaDTO> productos) throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosAZ(List<ProductoCafeteriaDTO> productos) throws CafeteriaException;

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosZA(List<ProductoCafeteriaDTO> productos) throws CafeteriaException;
}
