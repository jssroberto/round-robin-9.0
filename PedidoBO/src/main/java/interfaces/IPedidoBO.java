package interfaces;

import dominio.Pedido;
import dominio.Usuario;
import dtos.DetalleProductoDTO;
import dtos.PedidoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author yohan
 */
public interface IPedidoBO {

    public void persistir(Pedido pedido);

    public Pedido consultarPedido(Pedido numeroPedido);

    public void referenciarPedido(Usuario usuario, Pedido pedido);

    public List<PedidoDTO> consultarPedidos(String idUsuario) throws BOException, PersistenciaException;

    public PedidoDTO consultarPorId(String id) throws BOException, PersistenciaException;
    
        public List<DetalleProductoDTO> consultarDetalleProductosPorIdPedido(String idPedido) throws BOException, PersistenciaException;
}
