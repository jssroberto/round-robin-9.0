package idaos;

import dominio.Tarjeta;
import excepciones.BancoException;

/**
 *
 * @author Roberto García
 */
public interface ITarjetaDAO {

    public Tarjeta consultarTarjetaMongo(Tarjeta tarjeta) throws BancoException;

}
