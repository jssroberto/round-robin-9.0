/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Interfaz.IBusquedaBO;
import convertidores.ConvertidorDAOaDTO;
import convertidores.ConvertidorDTOaDAO;
import daos.ProductoCafeteriaDAO;
import dominio.ProductoCafeteria;
import dtos.ProductoCafeteriaDTO;
import dtos.ProductoDTO;
import excepciones.CafeteriaException;
import interfaces.IProductoCafeteriaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yohan
 */
public class BusquedaBO implements IBusquedaBO {

    public BusquedaBO() {
    }

    
    public ProductoCafeteriaDTO convertirDAOenDTO(ProductoCafeteria productoCafeteria) {
        ProductoCafeteriaDTO productoCafeteriaDTO = new ProductoCafeteriaDTO();

        productoCafeteriaDTO.setPrecio(productoCafeteria.getPrecio());
        productoCafeteriaDTO.setNombre(productoCafeteria.getNombre());
        productoCafeteriaDTO.setDescripcion(productoCafeteria.getDescripcion());
        productoCafeteriaDTO.setCantidadDisponible(productoCafeteria.getCantidadDisponible());
        productoCafeteriaDTO.setDireccionImagen(productoCafeteria.getDireccionImagen());
        productoCafeteriaDTO.setId(productoCafeteria.getId());
        productoCafeteriaDTO.setIdProductoCafeteria(productoCafeteria.getCodigo());
        return productoCafeteriaDTO;
    }


    @Override
    public List<ProductoCafeteriaDTO> consultarProductos(String palabra) throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.consultarProductos(palabra);
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosAZ() throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosAZ();
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosZA() throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosZA();
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosPorPrecio() throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosPorPrecio();
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> pro = new ArrayList<>();
        for (ProductoCafeteriaDTO p : productos) {
            pro.add(convertirDTOenDAO(p));
        }
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosFiltradosPorPrecio(pro);
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosAZ(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> pro = new ArrayList<>();
        for (ProductoCafeteriaDTO p : productos) {
            pro.add(convertirDTOenDAO(p));
        }
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosFiltradosAZ(pro);
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }

    @Override
    public List<ProductoCafeteriaDTO> ordenarProductosFiltradosZA(List<ProductoCafeteriaDTO> productos) throws CafeteriaException {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        List<ProductoCafeteriaDTO> productosDTO = new ArrayList<>();
        List<ProductoCafeteria> pro = new ArrayList<>();
        for (ProductoCafeteriaDTO p : productos) {
            pro.add(convertirDTOenDAO(p));
        }
        List<ProductoCafeteria> productosCafeteria = productoCafeteriaDAO.ordenarProductosFiltradosZA(pro);
        for (ProductoCafeteria producto : productosCafeteria) {
            ProductoCafeteriaDTO dto = this.convertirDAOenDTO(producto);
            productosDTO.add(dto);
        }
        return productosDTO;
    }
    public ProductoCafeteria convertirDTOenDAO(ProductoCafeteriaDTO productoCafeteriaDTO) {
        IProductoCafeteriaDAO productoCafeteriaDAO = new ProductoCafeteriaDAO();
        ProductoCafeteria productoCafeteria = new ProductoCafeteria();

        productoCafeteria.setPrecio(productoCafeteriaDTO.getPrecio());
        productoCafeteria.setNombre(productoCafeteriaDTO.getNombre());
        productoCafeteria.setDescripcion(productoCafeteriaDTO.getDescripcion());
        productoCafeteria.setCantidadDisponible(productoCafeteriaDTO.getCantidadDisponible());
        productoCafeteria.setDireccionImagen(productoCafeteriaDTO.getDireccionImagen());
        productoCafeteria.setId(productoCafeteriaDTO.getId());
        productoCafeteria.setCodigo(productoCafeteriaDTO.getIdProductoCafeteria());

        return productoCafeteria;
    }
}


