/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class Carrito {
    
//    private ObjectId id;
    private Float totalCarrito;
    private List<DetalleProducto> productos;

//    public Carrito(ObjectId id, Float total, List<DetalleProducto> productos) {
//        this.id = id;
//        this.totalCarrito = total;
//        this.productos = productos;
//    }

    public Carrito(Float total, List<DetalleProducto> productos) {
        this.totalCarrito = total;
        this.productos = productos;
    }

    public Carrito() {
        productos = new ArrayList<>();
    }
    

//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }

    public Float getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(Float totalCarrito) {
        this.totalCarrito = totalCarrito;
    }

    

    public List<DetalleProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleProducto> productos) {
        this.productos = productos;
    }
    
    @Override
    public String toString() {
        return "Carrito{"+ ", total=" + totalCarrito + ", productos=" + productos + '}';
    }
    
    
}
