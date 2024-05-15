/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inserciones;

import com.mongodb.client.MongoCollection;
import conexion.ConexionCia;
import dominio.UsuarioCia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class InsercionMasivaUsuariosCIA {
     private final MongoCollection<UsuarioCia> coleccionUsuarioCia;

    public InsercionMasivaUsuariosCIA() {
        this.coleccionUsuarioCia = ConexionCia.getDatabase().getCollection("cia", UsuarioCia.class);
    }
    
    public void insertarRegistros() throws Exception{
        List<UsuarioCia> usuariosCIA = new ArrayList<>();
        usuariosCIA.add(new UsuarioCia("00000011211", "ABC12345", "Juan", "Perez", "Garcia"));
        usuariosCIA.add(new UsuarioCia("00000244454", "DEF67890", "Maria", "Lopez", "Martinez"));
        usuariosCIA.add(new UsuarioCia("00000046574", "GHI13579", "Pedro", "Gonzalez", "Santos"));
        usuariosCIA.add(new UsuarioCia("00000240157", "JKL24680", "Ana", "Rodriguez", "Fernandez"));
        usuariosCIA.add(new UsuarioCia("00000244978", "MNO97531", "Luis", "Martinez", "Diaz"));
        
        coleccionUsuarioCia.insertMany(usuariosCIA);
        
    }
}
