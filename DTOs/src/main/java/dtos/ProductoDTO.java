package dtos;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


/**
 *
 * @author yohan
 */
 public class ProductoDTO {

    private String id;
    private String nombre;
    private Float precio;
    private Integer puntosCuesta, puntosGenera;
    private String descripcion;
    private String direccionImagen;

    public ProductoDTO(String id, String nombre, Float precio, Integer puntosCuesta, Integer puntosGenera, String descripcion, String direccionImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.puntosCuesta = puntosCuesta;
        this.puntosGenera = puntosGenera;
        this.descripcion = descripcion;
        this.direccionImagen = direccionImagen;
    }

    public ProductoDTO(String nombre, Float precio, Integer puntosCuesta, Integer puntosGenera, String descripcion, String direccionImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.puntosCuesta = puntosCuesta;
        this.puntosGenera = puntosGenera;
        this.descripcion = descripcion;
        this.direccionImagen = direccionImagen;
    }

    public ProductoDTO() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", puntosCuesta=" + puntosCuesta + ", puntosGenera=" + puntosGenera + ", descripcion=" + descripcion + ", direccionImagen=" + direccionImagen + '}';
    }

    

}