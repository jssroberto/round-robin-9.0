/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import DAOs.PedidoDAO;
import DAOs.UsuarioDAO;
import IDAOs.IPedidoDAO;
import IDAOs.IUsuarioDAO;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import insercionesMasivas.InsercionMasivaProductos;
import insercionesMasivas.InsercionMasivaUsuarios;
import java.io.IOException;

/**
 *
 * @author yohan
 */
public class pruebaMongo {

    public static void main(String[] args) throws IOException, Exception {

        InsercionMasivaProductos pro = new InsercionMasivaProductos();
//
        pro.insertarRegistros();
//        InsercionMasivaUsuarios u = new InsercionMasivaUsuarios();
//        u.insertarRegistros();

//        ProductoDAO pro = new ProductoDAO();
//        Producto pros = new Producto();
//        pros.setCodigoProducto("SCL100");
//        UsuarioDAO user = new UsuarioDAO();
//        Usuario user2 = new Usuario();
//        user2.setIdCia("00000244913");
//        System.out.println(pro.consultar(pros));
//        UsuarioDAO user = new UsuarioDAO();
//        Usuario u = new Usuario();
//        u.setIdCia("00000244913");
//        u = user.consultarUsuario(u);
//        
////        user.eliminarProductoCarrito(u.getId(), u.getCarrito().getProductos().get(0));
//        for (int i = 0; i < u.getCarrito().getProductos().size(); i++) {
//            user.eliminarProductoCarrito(u.getId(), u.getCarrito().getProductos().get(i));
//    PedidoDAO p = new PedidoDAO();
//        Pedido pe = new Pedido();
//        pe.setEtiquetaPedido("123455");
//        System.out.println(p.consultar(pe));
//    }
//            IUsuarioDAO user = new UsuarioDAO();
//            Usuario u = new Usuario();
//            u.setIdCia("00000011211");
//                    
//            System.out.println(user.actualizarTotalCarrito(user.consultarUsuario(u)));
//            DetalleProducto aa = new DetalleProducto();
//            aa.setCodigoProducto("HCL080");
//            user.eliminarProductoCarrito(user.consultarUsuario("00000011211").getId(), aa);
//            Usuario ue = new Usuario();
//            ue.setIdCia("00000011211");
//        System.out.println(user.consultarUsuario(ue));3
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        usuarioDAO.eliminarProductoDelCarrito("6645571172b91746a5c674a8", "CCN025");
        
    }

}
