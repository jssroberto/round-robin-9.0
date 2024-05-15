/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import control.ControlGenerarPuntos;
import dominio.DetalleProducto;
import excepciones.PersistenciaException;
import interfaces.IGenerarPuntos;
import java.util.List;

/**
 *
 * @author galan
 */
public class GenerarPuntos implements IGenerarPuntos{
    ControlGenerarPuntos c= new ControlGenerarPuntos();
    
    @Override
    public Integer generarPuntos(List<DetalleProducto> productos){
        return c.generarPuntos(productos);
    }
    
}
