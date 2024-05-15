/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insercionesMasivas;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Pedido;
import dominio.Usuario;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author yohan
 */
public class InsercionMasivaUsuarios {

    private final MongoCollection<Usuario> coleccionUsuarios;

    public InsercionMasivaUsuarios() {
        this.coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios", Usuario.class);
    }

    public void insertarRegistros() throws Exception {
        List<Usuario> usuario = new LinkedList<>();
        List<ObjectId> pedidos1 = new LinkedList<>();
        List<ObjectId> pedidos2 = new LinkedList<>();
        List<ObjectId> pedidos3 = new LinkedList<>();
        List<ObjectId> pedidos4 = new LinkedList<>();
        List<ObjectId> pedidos5 = new LinkedList<>();
        List<DetalleProducto> deta = new LinkedList<>();
        usuario.add(new Usuario("00000011211", "Juan", "Perez", "Garcia", new Carrito(0.0f, deta), 0, pedidos1));
        usuario.add(new Usuario("00000244454", "Maria", "Lopez", "Martinez", new Carrito(0.0f, deta), 0, pedidos2));
        usuario.add(new Usuario("00000046574", "Pedro", "Gonzalez", "Santos", new Carrito(0.0f, deta), 0, pedidos3));
        usuario.add(new Usuario("00000240157", "Ana", "Rodriguez", "Fernandez", new Carrito(0.0f, deta), 0, pedidos4));
        usuario.add(new Usuario("00000244978", "Luis", "Martinez", "Diaz", new Carrito(0.0f, deta), 0, pedidos5));
        try {
            coleccionUsuarios.insertMany(usuario);
        } finally {
            Conexion.close();
        }
    }

}
