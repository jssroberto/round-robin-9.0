/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.DetalleProducto;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author galan
 */
public interface IGenerarPuntos {
    public Integer generarPuntos (List<DetalleProducto> productos);
}
