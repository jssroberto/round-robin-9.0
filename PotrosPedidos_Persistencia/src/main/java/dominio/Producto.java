/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class Producto {

    private ObjectId id;
    private String codigoProducto;
    private String nombre;
    private Float precio;
    private Integer puntosCuesta, puntosGenera;
    private String descripcion;
    private String direccionImagen;

    public Producto(ObjectId id, String codigoProducto, String nombre, Float precio, String descripcion, String direccionImagen) {
        this.id = id;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.direccionImagen = direccionImagen;
        this.puntosCuesta = Math.round(precio);
        this.puntosGenera = (int) Math.round(precio * 0.05);
    }

    public Producto(String codigoProducto, String nombre, Float precio, String descripcion, String direccionImagen) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.direccionImagen = direccionImagen;
        this.puntosCuesta = Math.round(precio);
        this.puntosGenera = (int) Math.round(precio * 0.05);
    }


    public Producto(ObjectId id) {
        this.id = id;
    }

    

    public Producto(String nombre, Float precio, String descripcion, String direccionImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.direccionImagen = direccionImagen;
    }

    public Producto() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
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

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("id=").append(id);
        sb.append(", codigoProducto=").append(codigoProducto);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", puntosCuesta=").append(puntosCuesta);
        sb.append(", puntosGenera=").append(puntosGenera);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", direccionImagen=").append(direccionImagen);
        sb.append('}');
        return sb.toString();
    }

    
}
