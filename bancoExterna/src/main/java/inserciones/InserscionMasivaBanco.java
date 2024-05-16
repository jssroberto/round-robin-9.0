package inserciones;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.ConexionBanco;
import dominio.Tarjeta;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza una inserción masiva de tarjetas en una colección de
 * tarjetas en una base de datos MongoDB.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class InserscionMasivaBanco {

    // Colección de tarjetas en la base de datos MongoDB
    private final MongoCollection<Tarjeta> coleccionTarjetas;

    /**
     * Constructor que inicializa la colección de tarjetas desde la base de
     * datos.
     */
    public InserscionMasivaBanco() {
        this.coleccionTarjetas = ConexionBanco.getDatabase().getCollection("tarjetas", Tarjeta.class);
    }

    /**
     * Realiza una inserción masiva de tarjetas en la base de datos MongoDB.
     *
     * @throws Exception si ocurre un error durante la inserción.
     */
    public void insercionMasivaBanco() throws Exception {
        List<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(new Tarjeta("4696164174646464", YearMonth.of(2030, 9).toString(), 754, 1000.0f));
        tarjetas.add(new Tarjeta("4696654274646464", YearMonth.of(2035, 2).toString(), 475, 1000.0f));
        tarjetas.add(new Tarjeta("4696164165466464", YearMonth.of(2032, 1).toString(), 277, 1000.0f));
        tarjetas.add(new Tarjeta("4696164174646541", YearMonth.of(2027, 11).toString(), 341, 1000.0f));
        tarjetas.add(new Tarjeta("1545164174646464", YearMonth.of(2025, 9).toString(), 734, 1000.0f));
        coleccionTarjetas.insertMany(tarjetas);
    }
}
