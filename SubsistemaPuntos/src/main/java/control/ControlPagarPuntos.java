/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuarioBO;
import Interfaz.IUsuarioBO;
import dominio.MetodoPago;
import dominio.Pedido;
import dominio.Usuario;
import interfaces.IControlCarrito;
import interfaces.IControlPedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galan
 */
public class ControlPagarPuntos {

    public ArrayList<String> PagarPuntos(Usuario usuario, Integer puntosPagar, Integer puntosGenera, String numPedido1) throws Exception {
        IControlPedido pedidoSub = new ControlPedido();
        IControlCarrito carritoSub = new ControlCarrito();
        IUsuarioBO usuarioBO = new UsuarioBO();
//        conexion.Conexion.getDatabase();
        ArrayList<String> arreglo = new ArrayList<>();
        try {
            Pedido pedidoGenerado = new Pedido();
            String numPedido = numPedido1;
            pedidoGenerado.setNumeroPedido(numPedido);
            arreglo.add(numPedido);
            String clave = pedidoSub.generateRandomString();
            pedidoGenerado.setClaveRecoleccion(clave);
            arreglo.add(clave);
            pedidoGenerado.setEtiquetaPedido(pedidoSub.generateRandomString());
            pedidoGenerado.setDetalleProductos(usuario.getCarrito().getProductos());
            pedidoGenerado.setMetodoPago(MetodoPago.PUNTOS);
            pedidoSub.persistir(pedidoGenerado);
            pedidoSub.referenciarPedido(usuario, pedidoSub.consultarPedido(pedidoGenerado));
            carritoSub.vaciarCarrito(usuario);
            System.out.println("xd");
            usuarioBO.actualizarPuntosUsuario(usuario, usuario.getSaldoPuntos()-puntosPagar+puntosGenera);
//            conexion.Conexion.close();
            return arreglo;
        } catch (Exception e) {
//            conexion.Conexion.close();
            throw new Exception(e.getCause());
        }
    }
}
