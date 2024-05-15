/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;



import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Producto;
import dominio.ProductoCafeteria;
import dominio.Tarjeta;
import dominio.Usuario;
import dtos.CarritoDTO;
import dtos.DetalleProductoDTO;
import dtos.PedidoDTO;
import dtos.ProductoCafeteriaDTO;
import dtos.ProductoDTO;
import dtos.TarjetaDTO;
import dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author galan
 */
public class ConvertidorDAOaDTO {

//    public UsuarioDTO convertirDAOenDTO(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//
//        usuarioDTO.setNombre(usuario.getNombre());
//        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
//        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
//        usuarioDTO.setCarrito(convertirDAOenDTO(usuario.getCarrito()));
//        usuarioDTO.setId(usuario.getId().toHexString());
//        usuarioDTO.setIdCia(usuario.getIdCia());
//        usuarioDTO.setSaldoPuntos(usuario.getSaldoPuntos());
//
//        List<String> lista = new ArrayList<>();
//        for (ObjectId producto : usuario.getPedidos()) {
//            lista.add(producto.toString());
//        }
//        usuarioDTO.setPedidos(lista);
//
//        return usuarioDTO;
//    }

    public ProductoDTO convertirDAOenDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setDireccionImagen(producto.getDireccionImagen());
        productoDTO.setId(producto.getId().toString());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setPuntosGenera(producto.getPuntosGenera());

        return productoDTO;
    }

    public ProductoCafeteriaDTO convertirDAOenDTO(ProductoCafeteria productoCafeteria) {
        ProductoCafeteriaDTO productoCafeteriaDTO = new ProductoCafeteriaDTO();

        productoCafeteriaDTO.setPrecio(productoCafeteria.getPrecio());
        productoCafeteriaDTO.setNombre(productoCafeteria.getNombre());
        productoCafeteriaDTO.setDescripcion(productoCafeteria.getDescripcion());
        productoCafeteriaDTO.setCantidadDisponible(productoCafeteria.getCantidadDisponible());
        productoCafeteriaDTO.setDireccionImagen(productoCafeteria.getDireccionImagen());
        productoCafeteriaDTO.setIdProductoCafeteria(productoCafeteria.getId());
        return productoCafeteriaDTO;
    }

    public CarritoDTO convertirDAOenDTO(Carrito carrito) {
        CarritoDTO carritoDTO = new CarritoDTO();

      
        carritoDTO.setTotal(carrito.getTotalCarrito());

        List<DetalleProductoDTO> lista = new ArrayList<>();
        for (DetalleProducto producto : carrito.getProductos()) {
            lista.add(convertirDAOenDTO(producto));
        }
        carritoDTO.setProductos(lista);

        return carritoDTO;
    }

    public DetalleProductoDTO convertirDAOenDTO(DetalleProducto detalleProducto) {
        DetalleProductoDTO detalleProductoDTO = new DetalleProductoDTO();

        detalleProductoDTO.setCantidad(detalleProducto.getCantidad());
        detalleProductoDTO.setCodigoProducto(detalleProducto.getCodigoProducto());
        detalleProductoDTO.setDireccionImagen(detalleProducto.getDireccionImagen());
        detalleProductoDTO.setId(detalleProducto.getId());
        detalleProductoDTO.setNombre(detalleProducto.getNombre());
        detalleProductoDTO.setPrecio(detalleProducto.getPrecio());
        detalleProductoDTO.setPuntosCuesta(detalleProducto.getPuntosCuesta());
        detalleProductoDTO.setPuntosGenera(detalleProducto.getPuntosGenera());
        detalleProductoDTO.setSubtotal(detalleProducto.getSubtotal());

        return detalleProductoDTO;
    }

    public TarjetaDTO convertirDAOenDTO(Tarjeta tarjeta) {
        TarjetaDTO tarjetaDTO = new TarjetaDTO();

        tarjetaDTO.setCvv(tarjeta.getCvv());
        tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDTO.setId(tarjeta.getId());
        tarjetaDTO.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        tarjetaDTO.setSaldo(tarjeta.getSaldo());

        return tarjetaDTO;
    }

    public PedidoDTO convertirDAOenDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setClaveRecoleccion(pedido.getClaveRecoleccion());
        pedidoDTO.setEtiquetaPedido(pedido.getEtiquetaPedido());
        pedidoDTO.setFecha(pedido.getFecha());
        pedidoDTO.setIdPedido(pedido.getId().toString());
        pedidoDTO.setMetodoPago(pedido.getMetodoPago().getCodigo());
        pedidoDTO.setNumeroPedido(pedido.getNumeroPedido());
        pedidoDTO.setNumeroProductos(pedido.getNumeroProductos());
        pedidoDTO.setTotal(pedido.getTotal());

        List<DetalleProductoDTO> lista = new ArrayList<>();
        for (DetalleProducto producto : pedido.getDetalleProductos()) {
            lista.add(convertirDAOenDTO(producto));
        }
        pedidoDTO.setDetalleProductos(lista);

        return pedidoDTO;
    }
}
