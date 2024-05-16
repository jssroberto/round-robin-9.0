package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author jl4ma
 */
/**
 * Clase que representa un usuario del CIA.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class UsuarioCia {

    private ObjectId id;
    private String idEstudiante;
    private String contrasena;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    /**
     * Constructor que inicializa todos los atributos de un usuario del CIA.
     *
     * @param id El identificador del usuario.
     * @param idEstudiante El identificador del estudiante.
     * @param contrasena La contraseña del usuario.
     * @param nombre El nombre del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     */
    public UsuarioCia(ObjectId id, String idEstudiante, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Constructor que inicializa todos los atributos de un usuario del CIA
     * excepto el identificador.
     *
     * @param idEstudiante El identificador del estudiante.
     * @param contrasena La contraseña del usuario.
     * @param nombre El nombre del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     */
    public UsuarioCia(String idEstudiante, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idEstudiante = idEstudiante;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Constructor por defecto.
     */
    public UsuarioCia() {
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return El identificador del usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id El identificador a establecer.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del estudiante.
     *
     * @return El identificador del estudiante.
     */
    public String getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * Establece el identificador del estudiante.
     *
     * @param idEstudiante El identificador del estudiante a establecer.
     */
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La contraseña a establecer.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El apellido paterno a establecer.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El apellido materno a establecer.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Devuelve una representación en forma de cadena de caracteres del objeto
     * UsuarioCia.
     *
     * @return Una cadena que contiene la información del usuario.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioCia{");
        sb.append("id=").append(id);
        sb.append(", idEstudiante=").append(idEstudiante);
        sb.append(", contrasena=").append(contrasena);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append('}');
        return sb.toString();
    }
}
