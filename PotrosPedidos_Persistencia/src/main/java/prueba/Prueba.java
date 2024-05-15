package prueba;




/**
 *
 * @author Roberto Garc�a
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        List<Usuario> usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Juan", "Perez", "Garcia", "00000011211"));
//        usuarios.add(new Usuario("Maria", "Lopez", "Martinez", "00000244454"));
//        usuarios.add(new Usuario("Pedro", "Gonzalez", "Santos", "00000046574"));
//        usuarios.add(new Usuario("Ana", "Rodriguez", "Fernandez","00000240157" ));
//        usuarios.add(new Usuario("Luis", "Martinez", "Diaz", "00000244978"));
//        
//
//        List<UsuarioCIA> usuariosCIA = new ArrayList<>();
//        usuariosCIA.add(new UsuarioCIA("00000011211", "ABC12345", "Juan", "Perez", "Garcia"));
//        usuariosCIA.add(new UsuarioCIA("00000244454", "DEF67890", "Maria", "Lopez", "Martinez"));
//        usuariosCIA.add(new UsuarioCIA("00000046574", "GHI13579", "Pedro", "Gonzalez", "Santos"));
//        usuariosCIA.add(new UsuarioCIA("00000240157", "JKL24680", "Ana", "Rodriguez", "Fernandez"));
//        usuariosCIA.add(new UsuarioCIA("00000244978", "MNO97531", "Luis", "Martinez", "Diaz"));
//        
//
//        List<Tarjeta> tarjetas = new ArrayList<>();
//        tarjetas.add(new Tarjeta("4696-1641-7464-6464", YearMonth.of(31,8), 754));
//        tarjetas.add(new Tarjeta("4696-6542-7464-6464", YearMonth.of(31,8), 475));
//        tarjetas.add(new Tarjeta("4696-1641-6546-6464", YearMonth.of(31,8), 277));
//        tarjetas.add(new Tarjeta("4696-1641-7464-6541", YearMonth.of(31,8), 341));
//        tarjetas.add(new Tarjeta("1545-1641-7464-6464", YearMonth.of(31,8), 734));
//        
//        List<ProductoCafeteria> productosCafeteria = new ArrayList<>();
//        productosCafeteria.add(new ProductoCafeteria(50.0F, "Torta cubana", "Deliciosa", 15));
//        productosCafeteria.add(new ProductoCafeteria(100.0F, "Pizza de pepperoni", "Italiana", 15));
//        productosCafeteria.add(new ProductoCafeteria(25.0F, "Tacos de discada", "Mexicano", 15));
//        productosCafeteria.add(new ProductoCafeteria(100.0F, "Hamburguesa cl�sica", 15));
//        
//        EntityManagerFactory emfCafeteria = Persistence.createEntityManagerFactory("cafeteriaPU");
//        EntityManager emCafeteria = emfCafeteria.createEntityManager();
//        
//        emCafeteria.getTransaction().begin();
//        for (ProductoCafeteria productoCafeteria : productosCafeteria) {
//            emCafeteria.persist(productoCafeteria);
//        }
//        emCafeteria.getTransaction().commit();
//        emCafeteria.close();
//        
//        List<Producto> productos = new ArrayList<>();
//        productos.add(new Producto(50.0F, "Torta cubana", "Deliciosa",productosCafeteria.get(0).getId()));
//        productos.add(new Producto(100.0F, "Pizza de pepperoni", "Italiana",productosCafeteria.get(1).getId()));
//        productos.add(new Producto(25.0F, "Tacos de discada", "Mexicano",productosCafeteria.get(2).getId()));
//        productos.add(new Producto(100.0F, "Hamburguesa cl�sica","Americano",productosCafeteria.get(3).getId()));
//        
//        Carrito carrito= new Carrito(0.0F, 0, usuarios.get(0));
//        DetalleCarrito detalleCarrito= new DetalleCarrito(carrito, productos.get(0), 2, 100.0F);
//        carrito.setCantidadProductos(2);
//        carrito.setTotal(100.0F);
//
//        
//        EntityManagerFactory emfConexion = Persistence.createEntityManagerFactory("potrosPU");
//        EntityManagerFactory emfCIA = Persistence.createEntityManagerFactory("ciaPU");
//        EntityManagerFactory emfBanco = Persistence.createEntityManagerFactory("bancoPU");
//        
//        
//
//
//        EntityManager emConexion = emfConexion.createEntityManager();
//        EntityManager emCIA = emfCIA.createEntityManager();
//        EntityManager emBanco = emfBanco.createEntityManager();
//        
//
//        emConexion.getTransaction().begin();
//        for (Usuario usuario : usuarios) {
//            emConexion.persist(usuario);
//        }
//
//        emCIA.getTransaction().begin();
//        for (UsuarioCIA usuarioCIA : usuariosCIA) {
//            emCIA.persist(usuarioCIA);
//        }
//        emCIA.getTransaction().commit();
//        emCIA.close();
//
//        emBanco.getTransaction().begin();
//        for (Tarjeta tarjeta : tarjetas) {
//            emBanco.persist(tarjeta);
//        }
//        emBanco.getTransaction().commit();
//        emBanco.close();
//        
//        for (Producto producto : productos) {
//            emConexion.persist(producto);
//        }
//        emConexion.getTransaction().commit();
//
//        
//        
//        emConexion.getTransaction().begin();
//        emConexion.persist(carrito);
//        emConexion.persist(detalleCarrito);
//        emConexion.getTransaction().commit();

    }

}
