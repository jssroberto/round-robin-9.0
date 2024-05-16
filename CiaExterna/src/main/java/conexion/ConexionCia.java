package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase que gestiona la conexión a la base de datos del CIA.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class ConexionCia {

    private static MongoClient mongoClient = null;
    //Si se conectaron por Atlas su URL es la que les proporciona la página
//    private static final String URI = "mongodb+srv://josemadero244903:12345@cluster0.82cvjpv.mongodb.net/";//CAMBIEN PARA EL SUYO
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "cia_externo";

    public ConexionCia() {
        // Constructor privado para prevenir instanciación 
    }

    /**
     * Método estático que devuelve la base de datos del CIA.
     *
     * @return La base de datos del CIA configurada con los codecs adecuados.
     */
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {

            // 1. Configuramos el codec para manejar POJOs
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );
            //2.Configuramos los ajustes del cliente MongoDB, incluyendo la cadena de conexión (URL) y el registro de codecs anterior
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(URI))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            //3. Asignamos los ajustes al MongoCliente static del clase
            mongoClient = MongoClients.create(clientSettings);
            //4. Regresamos la base de datos con la configuración codecs
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);

        }
        // si no es null, la regresamos nuevamente
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    /**
     * Método estático para cerrar la conexión a la base de datos.
     */
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
