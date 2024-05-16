package interfaces;

import exepciones.CiaException;

/**
 * Interfaz que define los métodos para acceder a los datos de los usuarios del
 * CIA.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public interface IUsuarioCiaDAO {

    /**
     * Busca una persona (usuario) en la base de datos del CIA.
     *
     * @param idEstudiante El identificador del estudiante.
     * @param contra La contraseña proporcionada.
     * @return Verdadero si se encuentra la persona y la contraseña coincide,
     * falso de lo contrario.
     * @throws CiaException Si ocurre un error durante la búsqueda.
     */
    public Boolean BuscarPersona(String idEstudiante, String contra) throws CiaException;
}
