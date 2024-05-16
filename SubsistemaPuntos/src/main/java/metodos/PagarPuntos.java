/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import control.ControlPagarPuntos;
import dominio.Usuario;
import interfaces.IPagarPuntos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galan
 */
public class PagarPuntos implements IPagarPuntos{
    ControlPagarPuntos control= new ControlPagarPuntos();
    
    @Override
    public ArrayList<String> PagarPuntos(Usuario usuario, Integer puntosPagar, Integer puntosGenera, String numPedido1) throws Exception {
        return control.PagarPuntos(usuario, puntosPagar, puntosGenera, numPedido1);
    }  
}
