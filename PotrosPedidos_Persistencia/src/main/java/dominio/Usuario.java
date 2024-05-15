package dominio;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
public class Usuario {

    private ObjectId id;
    private String idCia;
    private String nombre, apellidoPaterno, apellidoMaterno;
    private Carrito carrito;
    private Integer saldoPuntos;
    private List<ObjectId> pedidos;

    public Usuario() {
        pedidos = new ArrayList<>();
    }

    public Usuario(ObjectId id, String idCia, String nombre, String apellidoPaterno, String apellidoMaterno, Carrito carrito, Integer saldoPuntos, List<ObjectId> pedidos) {
        this.id = id;
        this.idCia = idCia;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrito = carrito;
        this.saldoPuntos = saldoPuntos;
        this.pedidos = pedidos;
    }

    public Usuario(String idCia, String nombre, String apellidoPaterno, String apellidoMaterno, Carrito carrito, Integer saldoPuntos, List<ObjectId> pedidos) {
        this.idCia = idCia;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrito = carrito;
        this.saldoPuntos = saldoPuntos;
        this.pedidos = pedidos;
    }
    
    public Usuario(String idCia, String nombre, String apellidoPaterno, String apellidoMaterno, Carrito carrito, Integer saldoPuntos) {
        this.idCia = idCia;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrito = carrito;
        this.saldoPuntos = saldoPuntos;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public List<ObjectId> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ObjectId> pedidos) {
        this.pedidos = pedidos;
    }

 

    public String getIdCia() {
        return idCia;
    }

    public void setIdCia(String idCia) {
        this.idCia = idCia;
    }

    public Integer getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(Integer saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", idCia=" + idCia + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", carrito=" + carrito + ", saldoPuntos=" + saldoPuntos + ", pedidos=" + pedidos + '}';
    }
}
