/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import exepciones.CiaException;

/**
 *
 * @author jl4ma
 */
public interface IUsuarioCiaDAO {
    
    public Boolean BuscarPersona(String idEstudiante, String contra) throws CiaException;
}
