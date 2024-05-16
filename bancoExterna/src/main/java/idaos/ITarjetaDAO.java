package idaos;

import dominio.Tarjeta;
import excepciones.BancoException;

/**
 * Interfaz que define las operaciones de acceso a datos para las tarjetas en la
 * base de datos MongoDB.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public interface ITarjetaDAO {

    /**
     * Consulta una tarjeta en la base de datos MongoDB verificando que cumpla
     * con ciertos criterios de existencia y formato de los campos.
     *
     * @param tarjeta la tarjeta a consultar.
     * @return la tarjeta encontrada que cumple con los criterios especificados.
     * @throws BancoException si la tarjeta no está registrada o ocurre un error
     * en la consulta.
     */
    public Tarjeta consultarTarjetaMongo(Tarjeta tarjeta) throws BancoException;

    /**
     * Actualiza el saldo de una tarjeta en la base de datos MongoDB.
     *
     * @param tar la tarjeta cuyo saldo se va a actualizar.
     * @param saldo el nuevo saldo de la tarjeta.
     */
    public void actualizarSaldo(Tarjeta tar, float saldo);

}
