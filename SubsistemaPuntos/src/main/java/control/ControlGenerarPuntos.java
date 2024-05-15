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
public class ControlGenerarPuntos {
    public Integer generarPuntos(List<DetalleProducto> productos){
        Integer total=0;
        for (DetalleProducto producto : productos) {
            total+= producto.getPuntosGenera();
        }
        return total;
    }
}
