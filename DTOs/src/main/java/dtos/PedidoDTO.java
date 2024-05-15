/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author galan
 */
public class PedidoDTO {
    private String idPedido;
    private String etiquetaPedido;
    private String numeroPedido;
    private String claveRecoleccion;
    private LocalDate fecha;
    private Integer numeroProductos;
    private Float total;
    private int metodoPago;
    private List<DetalleProductoDTO> detalleProductos;

    public PedidoDTO(String idPedido, String etiquetaPedido, String numeroPedido, String claveRecoleccion, LocalDate fecha, Integer numeroProductos, Float total, int metodoPago, List<DetalleProductoDTO> detalleProductos) {
        this.idPedido = idPedido;
        this.etiquetaPedido = etiquetaPedido;
        this.numeroPedido = numeroPedido;
        this.claveRecoleccion = claveRecoleccion;
        this.fecha = fecha;
        this.numeroProductos = numeroProductos;
        this.total = total;
        this.metodoPago = metodoPago;
        this.detalleProductos = detalleProductos;
    }

    public PedidoDTO(String etiquetaPedido, String numeroPedido, String claveRecoleccion, LocalDate fecha, Integer numeroProductos, Float total, int metodoPago, List<DetalleProductoDTO> detalleProductos) {
        this.etiquetaPedido = etiquetaPedido;
        this.numeroPedido = numeroPedido;
        this.claveRecoleccion = claveRecoleccion;
        this.fecha = fecha;
        this.numeroProductos = numeroProductos;
        this.total = total;
        this.metodoPago = metodoPago;
        this.detalleProductos = detalleProductos;
    }

    public PedidoDTO() {
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getEtiquetaPedido() {
        return etiquetaPedido;
    }

    public void setEtiquetaPedido(String etiquetaPedido) {
        this.etiquetaPedido = etiquetaPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getClaveRecoleccion() {
        return claveRecoleccion;
    }

    public void setClaveRecoleccion(String claveRecoleccion) {
        this.claveRecoleccion = claveRecoleccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getNumeroProductos() {
        return numeroProductos;
    }

    public void setNumeroProductos(Integer numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetalleProductoDTO> getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(List<DetalleProductoDTO> detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "idPedido=" + idPedido + ", etiquetaPedido=" + etiquetaPedido + ", numeroPedido=" + numeroPedido + ", claveRecoleccion=" + claveRecoleccion + ", fecha=" + fecha + ", numeroProductos=" + numeroProductos + ", total=" + total + ", metodoPago=" + metodoPago + ", detalleProductos=" + detalleProductos + '}';
    }
    
    
}
