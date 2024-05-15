package org.itson.disenosw.main;

import conexion.ConexionCia;
import org.itson.disenosw.guis.FramePrincipal;
import java.util.logging.Logger;

/**
 * Clase principal del programa. Inicia la aplicación y establece la conexión
 * con la base de datos. Crea instancias de las clases DAO necesarias para
 * interactuar con la base de datos. Muestra la ventana principal de la
 * aplicación.
 */
public class Principal {

    static final Logger logger = Logger.getLogger(Principal.class.getName());

    public static void main(String[] args) {
        
        
        FramePrincipal framePrincipal = new FramePrincipal();
        framePrincipal.cambiarVistaInicio();
        framePrincipal.setVisible(true);

        System.out.println(System.getProperty("user.dir"));
    }
}
