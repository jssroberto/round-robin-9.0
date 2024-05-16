package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionCia;
import dominio.UsuarioCia;
import exepciones.CiaException;
import interfaces.IUsuarioCiaDAO;
import org.jasypt.util.binary.StrongBinaryEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

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
        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        try {
            UsuarioCia usuario = coleccionUsuarioCia.find(Filters.eq("idEstudiante", idEstudiante)).first();
            if (usuario != null) {
                // Obtener la contraseña encriptada almacenada en la base de datos
                String contrasenaEncriptada = usuario.getContrasena();
                // Verificar la contraseña ingresada con la contraseña encriptada
                if (spe.checkPassword(contra, contrasenaEncriptada)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new CiaException("Error al buscar persona", e);
        }
    }

}
