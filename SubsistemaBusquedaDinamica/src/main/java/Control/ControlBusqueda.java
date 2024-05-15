/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import BOs.BusquedaBO;
import dtos.ProductoCafeteriaDTO;
import excepciones.CafeteriaException;
import java.util.List;

/**
 *
 * @author yohan
 */
public class ControlBusqueda {

    BusquedaBO b = new BusquedaBO();

    public List<ProductoCafeteriaDTO> consultarProductos(String palabra) throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a = b.consultarProductos(palabra);
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosAZ() throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosAZ();
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosZA() throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosZA();
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosPorPrecio() throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosPorPrecio();
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosFiltradosPorPrecio(productos);
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosAZ(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosFiltradosAZ(productos);
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosZA(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            List<ProductoCafeteriaDTO> a =  b.ordenarProductosFiltradosZA(productos);
            return a;
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }
}
