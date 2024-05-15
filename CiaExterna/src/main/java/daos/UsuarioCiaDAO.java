/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionCia;
import dominio.UsuarioCia;
import exepciones.CiaException;
import interfaces.IUsuarioCiaDAO;

/**
 *
 * @author jl4ma
 */
public class UsuarioCiaDAO implements IUsuarioCiaDAO {

    private final MongoCollection<UsuarioCia> coleccionUsuarioCia;

    public UsuarioCiaDAO() {
        this.coleccionUsuarioCia = ConexionCia.getDatabase().getCollection("cia", UsuarioCia.class);
    }

    @Override
    public Boolean BuscarPersona(String idEstudiante, String contra) throws CiaException {
        
        try {
            UsuarioCia usuario = coleccionUsuarioCia.find(Filters.eq("idEstudiante", idEstudiante)).first();
            return usuario != null && usuario.getContrasena().equals(contra);
        } catch (Exception e) {
            throw new CiaException("Error al buscar persona", e);
        }
    }

}
