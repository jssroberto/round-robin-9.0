/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import BOs.BusquedaBO;
import dtos.ProductoCafeteriaDTO;
import excepciones.PersitenciaException;
import java.util.List;

/**
 *
 * @author yohan
 */
public class ControlBusqueda {

    BusquedaBO b = new BusquedaBO();

    public List<ProductoCafeteriaDTO> consultarProductos(String palabra) throws PersitenciaException {
        try {
            return b.consultarProductos(palabra);
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosAZ() throws PersitenciaException {
        try {
            return b.ordenarProductosAZ();
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosZA() throws PersitenciaException {
        try {
            return b.ordenarProductosZA();
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosPorPrecio() throws PersitenciaException {
        try {
            return b.ordenarProductosPorPrecio();
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteriaDTO> productos) throws PersitenciaException {
        try {
            return b.ordenarProductosFiltradosPorPrecio(productos);
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosAZ(List<ProductoCafeteriaDTO> productos) throws PersitenciaException {
        try {
            return b.ordenarProductosFiltradosAZ(productos);
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }

    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosZA(List<ProductoCafeteriaDTO> productos) throws PersitenciaException {
        try {
            return b.ordenarProductosFiltradosZA(productos);
        } catch (PersitenciaException e) {
            throw new PersitenciaException(e.getMessage());
        }
    }
}
