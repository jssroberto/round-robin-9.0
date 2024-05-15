package prueba;

import DAOs.UsuarioDAO;



/**
 *
 * @author Roberto García
 */
public class PruebaConsulta {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) {
      

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<ProductoCafeteria> cq = cb.createQuery(ProductoCafeteria.class);
//
//        Root<ProductoCafeteria> root = cq.from(ProductoCafeteria.class);
//
//        cq.select(root).where(cb.equal(root.get("id"), 1));
//
//        TypedQuery<ProductoCafeteria> query = em.createQuery(cq);
//
//        ProductoCafeteria producto = query.getSingleResult();
//
//        em.close();
//        System.out.println(producto.getDireccionImagen());
//
//        
//        File file = new File(producto.getDireccionImagen());
//        
//        System.out.println(file.getAbsolutePath());
//        
//        try {
////            BufferedImage bufferedImage = ImageIO.read(new File(producto.getDireccionImagen()));
//
////            Image image = 
//            
//            ImageInfo imageInfo = Imaging.getImageInfo(new File(producto.getDireccionImagen()));
////            System.out.println("Formato: " + imageInfo.getFormatName());
////            System.out.println("Ancho: " + imageInfo.getWidth());
////            System.out.println("Alto: " + imageInfo.getHeight());
//        } catch (IOException e) {
//            e.printStackTrace();
////        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
//          
//        UsuarioDAO user = new UsuarioDAO();
//        
//        
//        
//        List<ObjectId> pedidos = new ArrayList<>();
//        pedidos.add(new ObjectId());
//        pedidos.add(new ObjectId());
//        List<DetalleProducto> productos = new ArrayList<>();
//        productos.add(new DetalleProducto(new ObjectId(), 2, 0.0f, new Producto(new ObjectId(), "asdasd", 50.0f, "afasfa", "afasfaf",1L)));
//        
//        
//        
//        Usuario usuario = new Usuario("0000000","a", "s", "aa", new Date(1544492400000L), new Carrito(new ObjectId(),0.0f, productos),2, pedidos);
//        productos.add(new DetalleProducto(new ObjectId(), 2, 0.0f, new Producto(new ObjectId(), "asdfasasdadfaf", 100.0f, "fafafsafasdasdadasf", "asdasdasd", 2L)));
//        Usuario usuario2 = new Usuario("0000000","a", "s", "aa", new Date(1544492400000L), new Carrito(new ObjectId(),0.0f, productos),2, pedidos);
//        user.persistir(usuario);
        
//        user.agregarDetalleProductoAlCarrito(user.consultarUsuario("0000000").getId(), new DetalleProducto(2, 100.0f, new Producto(new ObjectId(),"aSasaSasA", 1111.0f, "adDA", "asdasddad",1L)));
//        user.eliminarProductoCarrito(user.consultarUsuario(usuario).getId(), user.consultarUsuario(usuario).getCarrito().getProductos().get(0));
            
    

//        List<ObjectId> pedidos = new ArrayList<>();
//
//        List<DetalleProducto> productos = new ArrayList<>();
//
//        Usuario usuario = new Usuario(
//                "00000244913",
//                "Roberto",
//                "Garcia",
//                "Armenta",
//                new Carrito(new ObjectId(), 0.0f, productos),
//                0,
//                pedidos);
//        
//        usuarioDAO.persistir(usuario);
//
//        productos.add(new DetalleProducto(
//                new ObjectId(),
//                2,
//                200.0f,
//                new Producto(new ObjectId(), 6L, "CAN100","Cangreburger", 100.0f, "Deli", "cangreburger.png")));
//
//        usuarioDAO.agregarDetalleProductoAlCarrito(usuarioDAO.consultarUsuario(usuario).getId(),
//                productos.get(0));
//        
//        Usuario usuario2 = new Usuario("0000000", "a", "s", "aa", new Date(1544492400000L), new Carrito(new ObjectId(), 0.0f, productos), 2, pedidos);
//        usuarioDAO.persistir(usuario);
//        user.eliminarProductoCarrito(user.consultarUsuario("0000000").getId(), user.consultarUsuario("0000000").getCarrito().getProductos().get(0));
   

    }
    
}
