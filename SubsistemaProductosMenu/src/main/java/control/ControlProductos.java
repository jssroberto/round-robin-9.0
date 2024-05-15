/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.ProductoCafeteria;
import excepciones.PersitenciaException;
import interfaces.IControlProductos;
import java.util.List;
import metodos.ConsultarProductos;

/**
 *
 * @author jl4ma
 */
public class ControlProductos implements IControlProductos{
    
    ConsultarProductos consultar;
    
    public ControlProductos(){
        consultar = new ConsultarProductos();
    }
    
    @Override
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws PersitenciaException{
        return consultar.obtenerTodosLosProductos();
    }
    
    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorID(Long id) throws PersitenciaException{
        return consultar.buscarProductoCafeteriaPorID(id);
    }
    
    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws PersitenciaException{
        return consultar.consultarProductosPorCodigo(codigo);
    }
}
