/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author galan
 */
public class CarritoDTO {
    
    private String id;
    private Float total;
    private List<DetalleProductoDTO> productos;

    public CarritoDTO(String id, Float total, List<DetalleProductoDTO> productos) {
        this.id = id;
        this.total = total;
        this.productos = productos;
    }

    public CarritoDTO(Float total, List<DetalleProductoDTO> productos) {
        this.total = total;
        this.productos = productos;
    }

    public CarritoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<DetalleProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleProductoDTO> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "CarritoDTO{" + "id=" + id + ", total=" + total + ", productos=" + productos + '}';
    }
    
    

    
}
