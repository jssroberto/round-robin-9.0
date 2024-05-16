package pruebas;

import inserciones.InserscionMasivaBanco;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class BancoExterna {

    public static void main(String[] args) {
        try {
            InserscionMasivaBanco imb = new InserscionMasivaBanco();

            imb.insercionMasivaBanco();

        } catch (Exception ex) {
            Logger.getLogger(BancoExterna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
