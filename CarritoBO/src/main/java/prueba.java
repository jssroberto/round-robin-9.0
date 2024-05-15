
import dominio.Carrito;
import dominio.DetalleProducto;
import dominio.Producto;
import dominio.Usuario;
import excepciones.PersistenciaException;
import interfaces.ICarritoBO;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.CarritoBO;
import org.bson.types.ObjectId;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jl4ma
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {

        ICarritoBO carro = new CarritoBO();
        List<ObjectId> pro = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setIdCia("00000244913");
        Producto prod = new Producto();
        prod.setCodigoProducto("SCL100");
        carro.agregarCarrito(usuario, prod, 2);
    }
    
}
