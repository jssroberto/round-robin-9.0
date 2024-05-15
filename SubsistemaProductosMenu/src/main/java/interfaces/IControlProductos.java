/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.ProductoCafeteria;
import excepciones.PersitenciaException;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IControlProductos {
    
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws PersitenciaException;
     public ProductoCafeteria buscarProductoCafeteriaPorID(Long id) throws PersitenciaException;
     public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws PersitenciaException;
}
