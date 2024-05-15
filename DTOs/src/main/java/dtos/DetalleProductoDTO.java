/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import org.bson.types.ObjectId;

/**
 *
 * @author galan
 */
public class DetalleProductoDTO {
    private ObjectId id;
    private Integer cantidad;
    private Float subtotal;
    private String nombre;
    private Float precio;
    private Integer puntosCuesta, puntosGenera;
    private String direccionImagen;
    private String codigoProducto;

    public DetalleProductoDTO(ObjectId id, Integer cantidad, Float subtotal, String nombre, Float precio, Integer puntosCuesta, Integer puntosGenera, String direccionImagen, String codigoProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.nombre = nombre;
        this.precio = precio;
        this.puntosCuesta = puntosCuesta;
        this.puntosGenera = puntosGenera;
        this.direccionImagen = direccionImagen;
        this.codigoProducto = codigoProducto;
    }

    public DetalleProductoDTO() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getPuntosCuesta() {
        return puntosCuesta;
    }

    public void setPuntosCuesta(Integer puntosCuesta) {
        this.puntosCuesta = puntosCuesta;
    }

    public Integer getPuntosGenera() {
        return puntosGenera;
    }

    public void setPuntosGenera(Integer puntosGenera) {
        this.puntosGenera = puntosGenera;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    

    
}
