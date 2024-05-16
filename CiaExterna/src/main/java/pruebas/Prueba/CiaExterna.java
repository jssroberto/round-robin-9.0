package pruebas.Prueba;

import inserciones.InsercionMasivaUsuariosCIA;

/**
 * 
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class CiaExterna {

    public static void main(String[] args) throws Exception {
        InsercionMasivaUsuariosCIA i = new InsercionMasivaUsuariosCIA();
        
        i.insertarRegistros();

    }
}
