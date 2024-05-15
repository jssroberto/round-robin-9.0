/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pruebas;

import daos.ProductoCafeteriaDAO;
import dominio.ProductoCafeteria;
import inserciones.InsercionMasivaProductosCafeteria;
import interfaces.IProductoCafeteriaDAO;

/**
 *
 * @author Roberto García
 */
public class CafeteriaExterna {

    public static void main(String[] args) throws Exception {
//        InsercionMasivaProductosCafeteria i = new InsercionMasivaProductosCafeteria();
//        
//        i.insertarRegistros();

    IProductoCafeteriaDAO c = new ProductoCafeteriaDAO();
    for(ProductoCafeteria c22: c.obtenerTodosLosProductos()){
        System.out.println(c22);
    }
    }
}
