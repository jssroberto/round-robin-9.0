/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pruebas;

import daos.TarjetaDAO;
import dominio.Tarjeta;
import idaos.ITarjetaDAO;
import inserciones.InserscionMasivaBanco;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto García
 */
public class BancoExterna {

    public static void main(String[] args) {
        try {
//            InserscionMasivaBanco imb = new InserscionMasivaBanco();
//            
//            imb.insercionMasivaBanco();
            ITarjetaDAO tarjetaDAO = new TarjetaDAO();
            Tarjeta tarjeta = tarjetaDAO.consultarTarjetaMongo(new Tarjeta("4696164174646464", "2030-09", 754));
            System.out.println(tarjeta.toString());
        } catch (Exception ex) {
            Logger.getLogger(BancoExterna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
