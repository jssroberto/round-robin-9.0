/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import interfaces.IProductoCafeteriaBO;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.ProductoCafeteriaBO;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class ConsultarProductos {
    
    IProductoCafeteriaBO producto;
    
    public ConsultarProductos(){
        producto = new ProductoCafeteriaBO();
    }
    
    
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws CafeteriaException{
        List<ProductoCafeteria> productos;
        
        productos = this.producto.obtenerTodosLosProductos();
        if(productos.isEmpty()){
//            JOptionPane.showMessageDialog(null, "Lista Vacia");
            return null;
        }else{
//            JOptionPane.showMessageDialog(null, "Lista de Productos");
            return productos;
        }
    }
    
    public ProductoCafeteria buscarProductoCafeteriaPorID(ObjectId id) throws CafeteriaException{
        ProductoCafeteria pro;
         
        pro = producto.buscarProductoCafeteriaPorID(id);
        if (pro == null) {
//            JOptionPane.showMessageDialog(null, "Producto null");
            return null;
        } else {
//            JOptionPane.showMessageDialog(null, "Producto encontrado");
            return pro;
        }
    }
    
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws CafeteriaException{
        ProductoCafeteria pro = producto.consultarProductosPorCodigo(codigo);
        if(pro==null){
            throw  new CafeteriaException("Producto encontrado ");
        }else{
            return pro;
        }
    }
}
