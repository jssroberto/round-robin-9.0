/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.DetalleProducto;
import java.util.List;

/**
 *
 * @author galan
 */
public class ControlCalcularCostoPuntos {
    
    public Integer calcularCosto(List<DetalleProducto> productos){
        conexion.Conexion.getDatabase();
        Integer total=0;
        for (DetalleProducto producto : productos) {
            total+= producto.getPuntosCuesta();
        }
        conexion.Conexion.close();
        return total;
    }
}
