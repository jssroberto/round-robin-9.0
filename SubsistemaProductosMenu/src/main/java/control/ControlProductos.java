/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import interfaces.IControlProductos;
import java.util.List;
import metodos.ConsultarProductos;
import org.bson.types.ObjectId;

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
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException{
//        conexion.ConexionCafeteria.getDatabase();
        List<ProductoCafeteria> a= consultar.obtenerTodosLosProductos();
//        conexion.ConexionCafeteria.close();
        return a;
    }
    
    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException{
//        conexion.ConexionCafeteria.getDatabase();
        ProductoCafeteria a = consultar.buscarProductoCafeteriaPorID(id);
//        conexion.ConexionCafeteria.close();
        return a;
    }
    
    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException{
//        conexion.ConexionCafeteria.getDatabase();
        ProductoCafeteria a = consultar.consultarProductosPorCodigo(codigo);
//        conexion.ConexionCafeteria.close();
        return a;
    }
}
