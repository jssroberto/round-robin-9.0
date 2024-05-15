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
public class ProductoCafeteria {
    

    private ObjectId id;
    private Float precio;
    private String nombre;
    private String descripcion;
    private Integer cantidadDisponible;
    private String direccionImagen;
    private String codigo;

    public ProductoCafeteria(ObjectId id, Float precio, String nombre, String descripcion, Integer cantidadDisponible, String direccionImagen, String codigo) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.direccionImagen = direccionImagen;
        this.codigo = codigo;
    }

    public ProductoCafeteria(String codigo,Float precio, String nombre, String descripcion, Integer cantidadDisponible, String direccionImagen) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.direccionImagen = direccionImagen;
        this.codigo = codigo;
    }

    public ProductoCafeteria() {
    }
    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductoCafeteria{");
        sb.append("id=").append(id);
        sb.append(", precio=").append(precio);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", cantidadDisponible=").append(cantidadDisponible);
        sb.append(", direccionImagen=").append(direccionImagen);
        sb.append(", codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
