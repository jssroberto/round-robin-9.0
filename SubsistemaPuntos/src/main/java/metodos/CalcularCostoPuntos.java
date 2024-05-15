/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import control.ControlCalcularCostoPuntos;
import dominio.DetalleProducto;
import interfaces.ICalcularCostoPuntos;
import java.util.List;

/**
 *
 * @author galan
 */
public class CalcularCostoPuntos implements ICalcularCostoPuntos{
    ControlCalcularCostoPuntos c= new ControlCalcularCostoPuntos();
    
    @Override
    public Integer calcularCostoPuntos(List<DetalleProducto> productos){
        return c.calcularCosto(productos);
    }
}
