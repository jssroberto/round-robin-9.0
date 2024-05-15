/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import DAOs.PedidoDAO;
import DAOs.UsuarioDAO;
import IDAOs.IPedidoDAO;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import dtos.DetalleProductoDTO;
import dtos.PedidoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import interfaces.IPedidoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yohan
 */
public class PedidosBO implements IPedidoBO {


    public PedidosBO() {
        
    }

    @Override
    public void persistir(Pedido pedido) {
        IPedidoDAO pedidosDAO = new PedidoDAO();
        try {
            pedidosDAO.persistir(pedido);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PedidosBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pedido consultarPedido(Pedido etiqueta) {
        IPedidoDAO pedidosDAO = new PedidoDAO();
        try {
            return pedidosDAO.consultar(etiqueta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PedidosBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
        UsuarioDAO user = new UsuarioDAO();
        user.referenciarPedido(usuario, pedido);
    }
// da error por que estas metiendo convertidores desde cafeteria y banco, saludos!!!

    /**
     *
     * @param idUsuario
     * @return
     * @throws BOException
     * @throws PersistenciaException
     */
    @Override
    public List<PedidoDTO> consultarPedidos(String idUsuario) throws BOException, PersistenciaException {
        IPedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.consultarPedidos(idUsuario);
        if (pedidos.isEmpty()) {
            throw new BOException("El usuario no tiene pedidos asociados");
        }
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidoDTOs.add(convertirDAOenDTO(pedido));
        }
        return pedidoDTOs;
    }

    @Override
    public PedidoDTO consultarPorId(String idPedido) throws BOException, PersistenciaException {
        IPedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = pedidoDAO.consultarPorId(idPedido);
        PedidoDTO pedidoDTO = convertirDAOenDTO(pedido);
        return pedidoDTO;
    }

    @Override
    public List<DetalleProductoDTO> consultarDetalleProductosPorIdPedido(String idPedido) throws BOException, PersistenciaException {
        IPedidoDAO pedidoDAO = new PedidoDAO();
        List<DetalleProducto> detalleProductos = pedidoDAO.consultarDetalleProductosPorIdPedido(idPedido);
        List<DetalleProductoDTO> detalleProductoDTOs = new ArrayList<>();

        for (DetalleProducto detalleProducto : detalleProductos) {
            detalleProductoDTOs.add(convertirDAOenDTO(detalleProducto));
        }
        return detalleProductoDTOs;

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

}
