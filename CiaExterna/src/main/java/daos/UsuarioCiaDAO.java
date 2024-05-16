package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionCia;
import dominio.UsuarioCia;
import exepciones.CiaException;
import interfaces.IUsuarioCiaDAO;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * Implementación del interfaz IUsuarioCiaDAO que gestiona las operaciones de
 * acceso a datos para los usuarios del CIA.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class UsuarioCiaDAO implements IUsuarioCiaDAO {

    private final MongoCollection<UsuarioCia> coleccionUsuarioCia;

    /**
     * Constructor que inicializa la colección de usuarios del CIA.
     */
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
