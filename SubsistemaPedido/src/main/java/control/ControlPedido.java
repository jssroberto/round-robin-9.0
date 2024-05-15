/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import dtos.DetalleProductoDTO;
import dtos.PedidoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import interfaces.IControlPedido;
import interfaces.IPedidoBO;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import objetosNegocio.PedidosBO;

/**
 *
 * @author jl4ma
 */
public class ControlPedido implements IControlPedido {

    IPedidoBO pedidos;

    public ControlPedido() {
        pedidos = new PedidosBO();
    }

    @Override
    public void persistir(Pedido pedido) {
        float total = 0;
        for (DetalleProducto pe : pedido.getDetalleProductos()) {
            total += pe.getSubtotal();
        }
        pedido.setTotal(total);
        pedidos.persistir(pedido);
    }

    @Override
    public Pedido consultarPedido(Pedido numeroPedido) {
        return pedidos.consultarPedido(numeroPedido);
    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
        pedidos.referenciarPedido(usuario, pedido);
    }

    @Override
    public boolean pedidoAceptado() {
        if (this.getRandomBinaryValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getRandomBinaryValue() {
        Random random = new Random();
        return random.nextInt(2); // Genera un valor aleatorio entre 0 y 1
    }
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final int STRING_LENGTH = 6;

    @Override
    public String generateRandomString() {
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        Random random = new Random();

        // Agrega 3 letras aleatorias
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        // Agrega 3 números aleatorios
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(NUMBERS.length());
            char randomNumber = NUMBERS.charAt(randomIndex);
            sb.append(randomNumber);
        }

        return sb.toString();
    }

    @Override
    public List<PedidoDTO> consultarPedidos(String idUsuario) throws BOException, PersistenciaException {

        IPedidoBO pedidoBO = new PedidosBO();
        List<PedidoDTO> pedidoDTOs = pedidoBO.consultarPedidos(idUsuario);
        return pedidoDTOs;
    }
    
    
    @Override
    public PedidoDTO consultarPorId(String idPedido) throws BOException, PersistenciaException{
        IPedidoBO pedidoBO = new PedidosBO();
        PedidoDTO pedidoDTO = pedidoBO.consultarPorId(idPedido);
        return pedidoDTO;
    }
    
    @Override
    public List<DetalleProductoDTO> consultarDetalleProductosPorIdPedido(String idPedido) throws BOException, PersistenciaException {
        IPedidoBO pedidoBO = new PedidosBO();
        List<DetalleProductoDTO> detalleProductoDTOs = pedidoBO.consultarDetalleProductosPorIdPedido(idPedido);
        return detalleProductoDTOs;
    }
    
}
