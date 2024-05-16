package BOs;

import DAOs.UsuarioDAO;
import IDAOs.IUsuarioDAO;
import Interfaz.IUsuarioBO;
import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import dtos.CarritoDTO;
import dtos.DetalleProductoDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author yohan
 */
public class UsuarioBO implements IUsuarioBO {

    public UsuarioBO() {
    }

//    public Usuario convertirDTOenDAO(UsuarioDTO usuarioDTO) {
//        Usuario usuario = new Usuario();
//
//        usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
//        usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
//        usuario.setIdCia(usuarioDTO.getIdCia());
//        usuario.setSaldoPuntos(usuario.getSaldoPuntos());
//
//        List<ObjectId> lista = new ArrayList<>();
//        for (String pedido : usuarioDTO.getPedidos()) {
//            lista.add(new ObjectId(pedido));
//        }
//        usuario.setPedidos(lista);
//
//        return usuario;
//    }
//
//    public Carrito convertirDTOenDAO(CarritoDTO carritoDTO) {
//        Carrito carrito = new Carrito();
//
//        carrito.setTotalCarrito(carritoDTO.getTotal());
//
//        List<DetalleProducto> lista = new ArrayList<>();
//        for (DetalleProductoDTO producto : carritoDTO.getProductos()) {
//            lista.add(convertirDTOenDAO(producto));
//        }
//        carrito.setProductos(lista);
//
//        return carrito;
//    }
//
//    public DetalleProducto convertirDTOenDAO(DetalleProductoDTO detalleProductoDTO) {
//        DetalleProducto detalleProducto = new DetalleProducto();
//
//        detalleProducto.setCantidad(detalleProductoDTO.getCantidad());
//        detalleProducto.setCodigoProducto(detalleProductoDTO.getCodigoProducto());
//        detalleProducto.setDireccionImagen(detalleProductoDTO.getDireccionImagen());
//        detalleProducto.setNombre(detalleProductoDTO.getNombre());
//
//        detalleProducto.setPrecio(detalleProductoDTO.getPrecio());
//        detalleProducto.setPuntosCuesta(detalleProductoDTO.getPuntosCuesta());
//        detalleProducto.setPuntosGenera(detalleProductoDTO.getPuntosGenera());
//        detalleProducto.setSubtotal(detalleProductoDTO.getSubtotal());
//
//        return detalleProducto;
//    }
//
//    public UsuarioDTO convertirDAOenDTO(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//
//        usuarioDTO.setNombre(usuario.getNombre());
//        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
//        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
//        usuarioDTO.setIdCia(usuario.getIdCia());
//        usuarioDTO.setCarrito(convertirDAOenDTO(usuario.getCarrito()));
//        usuarioDTO.setSaldoPuntos(usuario.getSaldoPuntos());
//
//        List<String> lista = new ArrayList<>();
//        for (ObjectId producto : usuario.getPedidos()) {
//            lista.add(producto.toHexString());
//        }
//        usuarioDTO.setPedidos(lista);
//
//        return usuarioDTO;
//
//    }
//    public CarritoDTO convertirDAOenDTO(Carrito carrito) {
//        CarritoDTO carritoDTO = new CarritoDTO();
//
//        carritoDTO.setTotal(carrito.getTotalCarrito());
//
//        List<DetalleProductoDTO> lista = new ArrayList<>();
//        for (DetalleProducto producto : carrito.getProductos()) {
//            lista.add(convertirDAOenDTO(producto));
//        }
//        carritoDTO.setProductos(lista);
//
//        return carritoDTO;
//    }
    public DetalleProductoDTO convertirDAOenDTO(DetalleProducto detalleProducto) {
        DetalleProductoDTO detalleProductoDTO = new DetalleProductoDTO();

        detalleProductoDTO.setCantidad(detalleProducto.getCantidad());
        detalleProductoDTO.setCodigoProducto(detalleProducto.getCodigoProducto());
        detalleProductoDTO.setDireccionImagen(detalleProducto.getDireccionImagen());
        detalleProductoDTO.setNombre(detalleProducto.getNombre());

        detalleProductoDTO.setPrecio(detalleProducto.getPrecio());
        detalleProductoDTO.setPuntosCuesta(detalleProducto.getPuntosCuesta());
        detalleProductoDTO.setPuntosGenera(detalleProducto.getPuntosGenera());
        detalleProductoDTO.setSubtotal(detalleProducto.getSubtotal());

        return detalleProductoDTO;
    }

    public ProductoDTO convertirDAOenDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();

        if (producto.getDescripcion() != null) {
            productoDTO.setDescripcion(producto.getDescripcion());
        }
        productoDTO.setDireccionImagen(producto.getDireccionImagen());
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setPuntosGenera(producto.getPuntosGenera());
        productoDTO.setPuntosGenera(producto.getPuntosGenera());

        return productoDTO;
    }

    public UsuarioDTO convertirDAOenDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDTO.setIdCia(usuario.getIdCia());
        usuarioDTO.setId(usuario.getId().toString());

        usuarioDTO.setCarrito(convertirDAOenDTO(usuario.getCarrito()));
        usuarioDTO.setSaldoPuntos(usuario.getSaldoPuntos());

        List<String> lista = new ArrayList<>();
        for (ObjectId producto : usuario.getPedidos()) {
            lista.add(producto.toHexString());
        }
        usuarioDTO.setPedidos(lista);

        return usuarioDTO;

    }

    public Carrito convertirDTOenDAO(CarritoDTO carritoDTO) {
        Carrito carrito = new Carrito();

        carrito.setTotalCarrito(carritoDTO.getTotal());

        List<DetalleProducto> lista = new ArrayList<>();
        for (DetalleProductoDTO producto : carritoDTO.getProductos()) {
            lista.add(convertirDTOenDAO(producto));
        }
        carrito.setProductos(lista);

        return carrito;
    }

    public DetalleProducto convertirDTOenDAO(DetalleProductoDTO detalleProductoDTO) {
        DetalleProducto detalleProducto = new DetalleProducto();

        detalleProducto.setCantidad(detalleProductoDTO.getCantidad());
        detalleProducto.setCodigoProducto(detalleProductoDTO.getCodigoProducto());
        detalleProducto.setDireccionImagen(detalleProductoDTO.getDireccionImagen());
        detalleProducto.setId(detalleProductoDTO.getId());
        detalleProducto.setNombre(detalleProductoDTO.getNombre());

        detalleProducto.setPrecio(detalleProductoDTO.getPrecio());
        detalleProducto.setPuntosCuesta(detalleProductoDTO.getPuntosCuesta());
        detalleProducto.setPuntosGenera(detalleProductoDTO.getPuntosGenera());
        detalleProducto.setSubtotal(detalleProductoDTO.getSubtotal());

        return detalleProducto;
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

    @Override
    public void persistir(UsuarioDTO usuario) {
//        if (usuario == null) {
//        } else {
//            usuarios.persistir(convertirDTOenDAO(usuario));
//        }
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuario == null) {
            return null;
        } else {
            return usuarioDAO.consultarUsuario(usuario);
        }
    }

    @Override
    public UsuarioDTO consultarUsuario(String idCia) throws BOException, PersistenciaException {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.consultarUsuario(idCia);
        UsuarioDTO usuarioDTO = convertirDAOenDTO(usuario);
        return usuarioDTO;

    }

//    public void referenciarPedido(Usuario usuario, Pedido pedido) {
//
//    }
    @Override
    public void actualizarPuntosUsuario(Usuario usuario, Integer puntos) {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();    
        usuarioDAO.actualizarPuntosUsuario(usuario, puntos);
    }
}
