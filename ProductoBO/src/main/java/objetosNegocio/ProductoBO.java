package objetosNegocio;

import DAOs.ProductoDAO;
import IDAOs.IProductoDAO;
import convertidores.ConvertidorDAOaDTO;
import dominio.Producto;
import dtos.ProductoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import interfaces.IProductoBO;

/**
 *
 * @author Roberto García
 */
public class ProductoBO implements IProductoBO {

    public ProductoDTO convertirDAOenDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setDireccionImagen(producto.getDireccionImagen());
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setPuntosGenera(producto.getPuntosGenera());

        return productoDTO;
    }
    @Override
    public void persistir(Producto producto) throws BOException {
        IProductoDAO productoDAO = new ProductoDAO();
        try {
            productoDAO.persistir(producto);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    @Override
    public ProductoDTO consultarProducto(Producto pro) throws BOException {
        IProductoDAO productoDAO = new ProductoDAO();

        try {
            Producto producto =productoDAO.consultar(pro);

            ConvertidorDAOaDTO convertidorDAOaDTO = new ConvertidorDAOaDTO();
            return convertirDAOenDTO(producto);
            //TODO cambiar Exception por DAOException
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    @Override
    public ProductoDTO consultarProducto(Long idProducto) throws BOException {
        IProductoDAO productoDAO = new ProductoDAO();
        try {
            Producto producto = productoDAO.consultar(idProducto);
            ConvertidorDAOaDTO convertidorDAOaDTO = new ConvertidorDAOaDTO();
            ProductoDTO productoDTO = convertirDAOenDTO(producto);
            return productoDTO;
            //TODO cambiar Exception por DAOException
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    
    @Override
    public ProductoDTO consultarPorCodigo(String codigoProducto) throws PersistenciaException {
        IProductoDAO productoDAO = new ProductoDAO();
        Producto producto = productoDAO.consultarPorCodigo(codigoProducto);
        ProductoDTO productoDTO = convertirDAOenDTO(producto);
        return productoDTO;
    }

}
