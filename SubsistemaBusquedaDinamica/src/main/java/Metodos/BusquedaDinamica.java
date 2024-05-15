/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Control.ControlBusqueda;
import dtos.ProductoCafeteriaDTO;
import excepciones.CafeteriaException;
import interfaces.IBusqueda;
import java.util.List;

/**
 *
 * @author yohan
 */
public class BusquedaDinamica implements IBusqueda {

       ControlBusqueda c = new ControlBusqueda();

    @Override
    public List<ProductoCafeteriaDTO> consultarProductos(String palabra) throws CafeteriaException {
        try {
            return c.consultarProductos(palabra);
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosAZ() throws CafeteriaException {
        try {
            return c.ordenarProductosAZ();
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosZA() throws CafeteriaException {
        try {
            return c.ordenarProductosZA();
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosPorPrecio() throws CafeteriaException {
        try {
            return c.ordenarProductosPorPrecio();
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            return c.ordenarProductosFiltradosPorPrecio(productos);
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosAZ(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            return c.ordenarProductosFiltradosAZ(productos);
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosZA(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        try {
            return c.ordenarProductosFiltradosZA(productos);
        } catch (CafeteriaException e) {
            throw new CafeteriaException(e.getMessage());
        }
    }

}
