/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inserciones;

import com.mongodb.client.MongoCollection;
import conexion.ConexionCafeteria;
import dominio.ProductoCafeteria;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class InsercionMasivaProductosCafeteria {
    
    private final MongoCollection<ProductoCafeteria> coleccionCafeteria;

    public InsercionMasivaProductosCafeteria() {
        this.coleccionCafeteria = ConexionCafeteria.getDatabase().getCollection("cafeteria", ProductoCafeteria.class);
    }
    
    public void insertarRegistros() throws Exception{
        List<ProductoCafeteria> productosCafeteria = new ArrayList<>();
        productosCafeteria.add(new ProductoCafeteria("HCL080",80.0F, "Hamburguesa clásica", "Hamburguesa con carne, queso y verdura, acompañada de papas a la francesa", 15 , "hamburguesa-clasica.png"));
        productosCafeteria.add(new ProductoCafeteria("HPL085",85.0F, "Hamburguesa pollo", "Hamburguesa con pollo empanizado, queso y verdura, acompañada de papas a la francesa", 50 , "hamburguesa-pollo.png"));
        productosCafeteria.add(new ProductoCafeteria("TML065",65.0F, "Torta de milanesa", "Torta con milanesa de res, queso verdura y aguacate", 15,"torta-milanesa.png"));
        productosCafeteria.add(new ProductoCafeteria("TCL070",70.0F, "Torta cubana", "Torta con jamón, queso, carne de puerco, verdura y aguacate", 15,"torta-cubana.png"));
        productosCafeteria.add(new ProductoCafeteria("SCL100",100.0F, "Sushi de camarón", "Sushi empanizado de camarón con alga, aguacate, pepino y philadelphia",30 , "sushi.png"));
        productosCafeteria.add(new ProductoCafeteria("SJL060",60.0F, "Sandwich", "Sandwich con jamón de pavo, queso y verdura", 30, "sandwich.png"));
        productosCafeteria.add(new ProductoCafeteria("AJL020", 20.0F, "Jamaica", "Jamaica natural de 500ml", 50, "jamaica.png"));
        productosCafeteria.add(new ProductoCafeteria("CCN025", 25.0F, "Coca-Cola", "Coca-Cola regular en lata de 355ml", 40, "coca-cola-regular.png"));
        productosCafeteria.add(new ProductoCafeteria("CCL025",25.0F, "Coca-Cola light", "Coca-Cola light en lata de 355ml", 40, "coca-cola-light.png"));
        productosCafeteria.add(new ProductoCafeteria("CCZ025", 25.0F, "Coca-Cola zero", "Coca-Cola zero en lata de 355ml", 40, "coca-cola-zero.png"));
    
    coleccionCafeteria.insertMany(productosCafeteria);
    }
            
}
