package inserciones;

import com.mongodb.client.MongoCollection;
import conexion.ConexionCafeteria;
import dominio.ProductoCafeteria;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la inserción masiva de productos en la base de datos de la
 * cafetería. Se encarga de agregar múltiples registros de productos a la
 * colección de la base de datos.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class InsercionMasivaProductosCafeteria {

    private final MongoCollection<ProductoCafeteria> coleccionCafeteria;

    /**
     * Constructor de la clase. Inicializa la conexión con la base de datos y
     * obtiene la colección de productos de la cafetería.
     */
    public InsercionMasivaProductosCafeteria() {
        this.coleccionCafeteria = ConexionCafeteria.getDatabase().getCollection("cafeteria", ProductoCafeteria.class);
    }

    /**
     * Método para insertar registros de productos en la base de datos. Los
     * productos se agregan a la colección de la cafetería.
     *
     * @throws Exception si ocurre algún error durante la inserción de los
     * productos.
     */
    public void insertarRegistros() throws Exception {
        List<ProductoCafeteria> productosCafeteria = new ArrayList<>();
        productosCafeteria.add(new ProductoCafeteria("HCL080", 80.0F, "Hamburguesa clásica", "Hamburguesa con carne, queso y verdura, acompañada de papas a la francesa", 15, "hamburguesa-clasica.png"));
        productosCafeteria.add(new ProductoCafeteria("HPL085", 85.0F, "Hamburguesa pollo", "Hamburguesa con pollo empanizado, queso y verdura, acompañada de papas a la francesa", 50, "hamburguesa-pollo.png"));
        productosCafeteria.add(new ProductoCafeteria("TML065", 65.0F, "Torta de milanesa", "Torta con milanesa de res, queso verdura y aguacate", 15, "torta-milanesa.png"));
        productosCafeteria.add(new ProductoCafeteria("TCL070", 70.0F, "Torta cubana", "Torta con jamón, queso, carne de puerco, verdura y aguacate", 15, "torta-cubana.png"));
        productosCafeteria.add(new ProductoCafeteria("SCL100", 100.0F, "Sushi de camarón", "Sushi empanizado de camarón con alga, aguacate, pepino y philadelphia", 30, "sushi.png"));
        productosCafeteria.add(new ProductoCafeteria("SJL060", 60.0F, "Sandwich", "Sandwich con jamón de pavo, queso y verdura", 30, "sandwich.png"));
        productosCafeteria.add(new ProductoCafeteria("AJL020", 20.0F, "Jamaica", "Jamaica natural de 500ml", 50, "jamaica.png"));
        productosCafeteria.add(new ProductoCafeteria("CCN025", 25.0F, "Coca-Cola", "Coca-Cola regular en lata de 355ml", 40, "coca-cola-regular.png"));
        productosCafeteria.add(new ProductoCafeteria("CCL025", 25.0F, "Coca-Cola light", "Coca-Cola light en lata de 355ml", 40, "coca-cola-light.png"));
        productosCafeteria.add(new ProductoCafeteria("CCZ025", 25.0F, "Coca-Cola zero", "Coca-Cola zero en lata de 355ml", 40, "coca-cola-zero.png"));

        productosCafeteria.add(new ProductoCafeteria("HDD090", 90.0F, "Hamburguesa Doble", "Hamburguesa doble con doble carne, queso y verduras, acompañada de papas a la francesa", 20, "hamburguesa-doble.png"));
        productosCafeteria.add(new ProductoCafeteria("TAP055", 55.0F, "Tacos al Pastor", "Tacos al pastor con carne de cerdo, piña, cebolla y cilantro", 25, "tacos-pastor.png"));
        productosCafeteria.add(new ProductoCafeteria("TPL070", 70.0F, "Torta de Pollo", "Torta con pollo asado, aguacate, queso y verduras frescas", 15, "torta-pollo.png"));
        productosCafeteria.add(new ProductoCafeteria("HDG050", 50.0F, "Hot Dog", "Hot dog con salchicha, salsa de tomate, mostaza, cebolla y jalapeños", 30, "hot-dog.png"));
        productosCafeteria.add(new ProductoCafeteria("ECS060", 60.0F, "Ensalada César", "Ensalada César con lechuga, pollo a la parrilla, crutones, parmesano y aderezo César", 20, "ensalada-cesar.png"));
        productosCafeteria.add(new ProductoCafeteria("PEP080", 80.0F, "Pizza de Pepperoni", "Pizza de pepperoni con salsa de tomate, queso mozzarella y rodajas de pepperoni", 15, "pizza-pepperoni.png"));
        productosCafeteria.add(new ProductoCafeteria("RMM030", 30.0F, "Refresco de Manzana", "Refresco de manzana en botella de 500ml", 35, "refresco-manzana.png"));
        productosCafeteria.add(new ProductoCafeteria("ADC040", 40.0F, "Agua de Coco", "Agua de coco natural en botella de 500ml", 40, "agua-coco.png"));
        productosCafeteria.add(new ProductoCafeteria("CAF035", 35.0F, "Café Americano", "Café americano negro servido en taza grande", 25, "cafe-americano.png"));
        productosCafeteria.add(new ProductoCafeteria("TEV025", 25.0F, "Té Verde", "Té verde natural servido en taza grande", 30, "te-verde.png"));

        coleccionCafeteria.insertMany(productosCafeteria);
    }

}
