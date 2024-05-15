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
//        conexion.Conexion.getDatabase();
        float total = 0;
        for (DetalleProducto pe : pedido.getDetalleProductos()) {
            total += pe.getSubtotal();
        }
        pedido.setTotal(total);
//        conexion.Conexion.close();
        pedidos.persistir(pedido);
    }

    @Override
    public Pedido consultarPedido(Pedido numeroPedido) {
//        conexion.Conexion.getDatabase();
        Pedido a =  pedidos.consultarPedido(numeroPedido);
//        conexion.Conexion.close();
        return a;
    }

    @Override
    public void referenciarPedido(Usuario usuario, Pedido pedido) {
//        conexion.Conexion.getDatabase();
        pedidos.referenciarPedido(usuario, pedido);
        conexion.Conexion.close();
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
//        conexion.Conexion.getDatabase();
        IPedidoBO pedidoBO = new PedidosBO();
        List<PedidoDTO> pedidoDTOs = pedidoBO.consultarPedidos(idUsuario);
//        conexion.Conexion.close();
        return pedidoDTOs;
    }
    
    
    @Override
    public PedidoDTO consultarPorId(String idPedido) throws BOException, PersistenciaException{
//        conexion.Conexion.getDatabase();
        IPedidoBO pedidoBO = new PedidosBO();
        PedidoDTO pedidoDTO = pedidoBO.consultarPorId(idPedido);
//        conexion.Conexion.close();
        return pedidoDTO;
    }
    
    @Override
    public List<DetalleProductoDTO> consultarDetalleProductosPorIdPedido(String idPedido) throws BOException, PersistenciaException {
//        conexion.Conexion.getDatabase();
        IPedidoBO pedidoBO = new PedidosBO();
        List<DetalleProductoDTO> detalleProductoDTOs = pedidoBO.consultarDetalleProductosPorIdPedido(idPedido);
//        conexion.Conexion.close();
        return detalleProductoDTOs;
    }
    
}
