/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insercionesMasivas;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import dominio.Producto;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class InsercionMasivaProductos {

    List<Producto> productoCafeterias = new LinkedList<>();
    private final MongoCollection<Producto> coleccionProducto;

    public InsercionMasivaProductos() {
        this.coleccionProducto = Conexion.getDatabase().getCollection("productos", Producto.class);
    }

    public void insertarRegistros() throws Exception {
        List<Producto> productosCafeteria = new LinkedList<>();
        productosCafeteria.add(new Producto("HCL080", "Hamburguesa clásica", 80.0F, "Hamburguesa con carne, queso y verdura, acompañada de papas a la francesa", "hamburguesa-clasica.png"));
        productosCafeteria.add(new Producto("HPL085", "Hamburguesa pollo", 85.0F, "Hamburguesa con pollo empanizado, queso y verdura, acompañada de papas a la francesa", "hamburguesa-pollo.png"));
        productosCafeteria.add(new Producto("TML065", "Torta de milanesa", 65.0F, "Torta con milanesa de res, queso verdura y aguacate", "torta-milanesa.png"));
        productosCafeteria.add(new Producto("TCL070", "Torta cubana", 70.0F, "Torta con jamón, queso, carne de puerco, verdura y aguacate", "torta-cubana.png"));
        productosCafeteria.add(new Producto("SCL100", "Sushi de camarón", 100.0F, "Sushi empanizado de camarón con alga, aguacate, pepino y philadelphia", "sushi.png"));
        productosCafeteria.add(new Producto("SJL060", "Sandwich", 60.0F, "Sandwich con jamón de pavo, queso y verdura", "sandwich.png"));
        productosCafeteria.add(new Producto("AJL020", "Jamaica", 20.0F, "Jamaica natural de 500ml", "jamaica.png"));
        productosCafeteria.add(new Producto("CCN025", "Coca-Cola", 25.0F, "Coca-Cola regular en lata de 355ml", "coca-cola-regular.png"));
        productosCafeteria.add(new Producto("CCL025", "Coca-Cola light", 25.0F, "Coca-Cola light en lata de 355ml", "coca-cola-light.png"));
        productosCafeteria.add(new Producto("CCZ025", "Coca-Cola zero", 25.0F, "Coca-Cola zero en lata de 355ml", "coca-cola-zero.png"));
        productosCafeteria.add(new Producto("HDD090", "Hamburguesa Doble", 90.0F, "Hamburguesa doble con doble carne, queso y verduras, acompañada de papas a la francesa", "hamburguesa-doble.png"));
        productosCafeteria.add(new Producto("TAP055", "Tacos al Pastor", 55.0F, "Tacos al pastor con carne de cerdo, piña, cebolla y cilantro", "tacos-pastor.png"));
        productosCafeteria.add(new Producto("TPL070", "Torta de Pollo", 70.0F, "Torta con pollo asado, aguacate, queso y verduras frescas", "torta-pollo.png"));
        productosCafeteria.add(new Producto("HDG050", "Hot Dog", 50.0F, "Hot dog con salchicha, salsa de tomate, mostaza, cebolla y jalapeños", "hot-dog.png"));
        productosCafeteria.add(new Producto("ECS060", "Ensalada César", 60.0F, "Ensalada César con lechuga, pollo a la parrilla, crutones, parmesano y aderezo César", "ensalada-cesar.png"));
        productosCafeteria.add(new Producto("PEP080", "Pizza de Pepperoni", 80.0F, "Pizza de pepperoni con salsa de tomate, queso mozzarella y rodajas de pepperoni", "pizza-pepperoni.png"));
        productosCafeteria.add(new Producto("RMM030", "Refresco de Manzana", 30.0F, "Refresco de manzana en botella de 500ml", "refresco-manzana.png"));
        productosCafeteria.add(new Producto("ADC040", "Agua de Coco", 40.0F, "Agua de coco natural en botella de 500ml", "agua-coco.png"));
        productosCafeteria.add(new Producto("CAF035", "Café Americano", 35.0F, "Café americano negro servido en taza grande", "cafe-americano.png"));
        productosCafeteria.add(new Producto("TEV025", "Té Verde", 25.0F, "Té verde natural servido en taza grande", "te-verde.png"));

        coleccionProducto.insertMany(productosCafeteria);

    }

}
