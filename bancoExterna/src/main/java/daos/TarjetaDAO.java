package daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.expr;
import com.mongodb.client.model.Updates;
import conexion.ConexionBanco;
import dominio.Tarjeta;
import excepciones.BancoException;
import idaos.ITarjetaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Roberto García
 */
public class TarjetaDAO implements ITarjetaDAO {

    private final MongoCollection<Tarjeta> coleccionTarjetas;

    public TarjetaDAO() {
        this.coleccionTarjetas = ConexionBanco.getDatabase().getCollection("tarjetas", Tarjeta.class);
    }

    @Override
    public Tarjeta consultarTarjetaMongo(Tarjeta tarjeta) throws BancoException {
        try {

            List<Tarjeta> result = coleccionTarjetas.aggregate(Arrays.asList(
                    match(and(
                            exists("numeroTarjeta", true), // Verificar si existe el campo numTarjeta
                            exists("cvv", true), // Verificar si existe el campo cvv
                            exists("fechaVencimiento", true), // Verificar si existe el campo fecha
                            expr("{$regexMatch: {input: 'numeroTarjeta', regex: /^[0-9]{16}$/}}"), // Verificar formato del número de tarjeta (16 dígitos)
                            expr("{$regexMatch: {input: '$cvv', regex: /^[0-9]{3,4}$/}}"), // Verificar formato del CVV (3 o 4 dígitos)
                            expr("{$regexMatch: {input: '$fecha', regex: /^[0-9]{4}-[0-9]{2}$/}}")// Verificar formato de la fecha (YYYY/MM)
                    )),
                    limit(1) // Limitar el resultado a un solo registro
            )).into(new ArrayList<>());
            if (result.isEmpty()) {
                throw new BancoException("La tarjeta no esta registrada");
            }
            Tarjeta tarjeta1 = result.get(0);

            return tarjeta1;
        } catch (MongoException e) {
            throw new BancoException(e.getMessage(), e);
        }
    }
    
    @Override
    public void actualizarSaldo(Tarjeta tar, float saldo){
        coleccionTarjetas.updateOne(Filters.eq("_id", tar.getId()), Updates.set("saldo", saldo));
    }

}
