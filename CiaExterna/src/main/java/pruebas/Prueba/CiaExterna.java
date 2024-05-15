/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pruebas.Prueba;

import daos.UsuarioCiaDAO;
import inserciones.InsercionMasivaUsuariosCIA;
import interfaces.IUsuarioCiaDAO;

/**
 *
 * @author Roberto García
 */
public class CiaExterna {

    public static void main(String[] args) throws Exception {
        InsercionMasivaUsuariosCIA i = new InsercionMasivaUsuariosCIA();
        
        i.insertarRegistros();
//        IUsuarioCiaDAO user = new UsuarioCiaDAO();
//        if (user.BuscarPersona("00000011211", "ABC12345")) {
//            System.out.println("si");
//        } else {
//            System.out.println("no");
//        }
    }
}
