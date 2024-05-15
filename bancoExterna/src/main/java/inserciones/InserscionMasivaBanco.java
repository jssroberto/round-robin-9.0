package inserciones;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import dominio.Tarjeta;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto García
 */
public class InserscionMasivaBanco {

    
    private final MongoCollection<Tarjeta> coleccionTarjetas;

    public InserscionMasivaBanco() {
        this.coleccionTarjetas = Conexion.getDatabase().getCollection("tarjetas", Tarjeta.class);
    }
    
    public void insercionMasivaBanco() throws Exception{
        List<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(new Tarjeta("4696164174646464", YearMonth.of(2030, 9).toString(), 754, 1000.0f));
        tarjetas.add(new Tarjeta("4696654274646464", YearMonth.of(2035, 2).toString(), 475, 1000.0f));
        tarjetas.add(new Tarjeta("4696164165466464", YearMonth.of(2032, 1).toString(), 277, 1000.0f));
        tarjetas.add(new Tarjeta("4696164174646541", YearMonth.of(2027, 11).toString(), 341, 1000.0f));
        tarjetas.add(new Tarjeta("1545164174646464", YearMonth.of(2025, 9).toString(), 734, 1000.0f));
        coleccionTarjetas.insertMany(tarjetas);
    }
}
