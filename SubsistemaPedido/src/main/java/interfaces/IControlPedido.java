/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Pedido;
import dominio.Usuario;
import dtos.DetalleProductoDTO;
import dtos.PedidoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IControlPedido {

    public void persistir(Pedido pedido);

    public Pedido consultarPedido(Pedido numeroPedido);

    public List<PedidoDTO> consultarPedidos(String idUsuario) throws BOException, PersistenciaException;

    public void referenciarPedido(Usuario usuario, Pedido pedido);

    public boolean pedidoAceptado();

    public String generateRandomString();

    public PedidoDTO consultarPorId(String idPedido) throws BOException, PersistenciaException;
    
     public List<DetalleProductoDTO> consultarDetalleProductosPorIdPedido(String idPedido) throws BOException, PersistenciaException;

    }
