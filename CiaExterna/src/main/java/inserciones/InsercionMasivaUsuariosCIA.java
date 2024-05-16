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
import org.jasypt.util.password.StrongPasswordEncryptor;

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
        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        
        String contra1 = spe.encryptPassword("ABC12345");
        String contra2 = spe.encryptPassword("DEF67890");
        String contra3 = spe.encryptPassword("GHI13579");
        String contra4 = spe.encryptPassword("JKL24680");
        String contra5 = spe.encryptPassword("MNO97531");
        List<UsuarioCia> usuariosCIA = new ArrayList<>();
        usuariosCIA.add(new UsuarioCia("00000011211", contra1, "Juan", "Perez", "Garcia"));
        usuariosCIA.add(new UsuarioCia("00000244454", contra2, "Maria", "Lopez", "Martinez"));
        usuariosCIA.add(new UsuarioCia("00000046574", contra3, "Pedro", "Gonzalez", "Santos"));
        usuariosCIA.add(new UsuarioCia("00000240157", contra4, "Ana", "Rodriguez", "Fernandez"));
        usuariosCIA.add(new UsuarioCia("00000244978", contra5, "Luis", "Martinez", "Diaz"));
        
        coleccionUsuarioCia.insertMany(usuariosCIA);
        
    }
}
