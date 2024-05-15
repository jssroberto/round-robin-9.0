/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import dominio.ProductoCafeteria;
import excepciones.PersitenciaException;
import interfaces.IProductoCafeteriaBO;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.ProductoCafeteriaBO;

/**
 *
 * @author jl4ma
 */
public class ConsultarProductos {
    
    IProductoCafeteriaBO producto;
    
    public ConsultarProductos(){
        producto = new ProductoCafeteriaBO();
    }
    
    
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws PersitenciaException{
        List<ProductoCafeteria> productos;
        
        productos = this.producto.obtenerTodosLosProductos();
        if(productos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista Vacia");
            return null;
        }else{
            JOptionPane.showMessageDialog(null, "Lista de Productos");
            return productos;
        }
    }
    
    public ProductoCafeteria buscarProductoCafeteriaPorID(Long id) throws PersitenciaException{
        ProductoCafeteria pro;
         
        pro = producto.buscarProductoCafeteriaPorID(id);
        if (pro == null) {
            JOptionPane.showMessageDialog(null, "Producto null");
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "Producto encontrado");
            return pro;
        }
    }
    
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws PersitenciaException{
        ProductoCafeteria pro = producto.consultarProductosPorCodigo(codigo);
        if(pro==null){
            throw  new PersitenciaException("Producto encontrado ");
        }else{
            return pro;
        }
    }
}
