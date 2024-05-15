/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import dominio.ProductoCafeteria;
import excepciones.PersitenciaException;
import interfaces.IProductoCafeteriaDAO;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jl4ma
 */
public class ProductoCafeteriaDAO implements IProductoCafeteriaDAO {

    private EntityManager em;
    private EntityManagerFactory emf;

    public ProductoCafeteriaDAO() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
        em = emf.createEntityManager();
    }

    @Override
    public void actualizarProducto(ProductoCafeteria productoCafeteria) throws PersitenciaException {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.merge(productoCafeteria);

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.close();
            System.out.println(e.getCause());
            throw new PersitenciaException("Error al actualizar producto de cafeteria");
        }
    }

    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorNombre(String nombreProducto) throws PersitenciaException {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql3 = "SELECT p FROM ProductoCafeteria p WHERE p.nombre = :nombre";

            TypedQuery<ProductoCafeteria> query = em.createQuery(jpql3, ProductoCafeteria.class);
            query.setParameter("nombre", nombreProducto);
            List<ProductoCafeteria> usuario = query.getResultList();

            em.getTransaction().commit();
            em.close();

            if (!usuario.isEmpty()) {
                return usuario.get(0);
            } else {
                throw new PersitenciaException("Producto no encontrado por su nombre");
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ProductoCafeteria buscarProductoCafeteriaPorID(Long id) throws PersitenciaException {
        try {
            em.getTransaction().begin();

            String jpql3 = "SELECT p FROM ProductoCafeteria p WHERE p.id = :id";

            TypedQuery<ProductoCafeteria> query = em.createQuery(jpql3, ProductoCafeteria.class);
            query.setParameter("id", id);
            List<ProductoCafeteria> usuario = query.getResultList();

            em.getTransaction().commit();

            for (ProductoCafeteria pro : usuario) {
                return pro;
            }
        } catch (Exception e) {
            throw new PersitenciaException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProductoCafeteria> obtenerTodosLosProductos() throws PersitenciaException {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ProductoCafeteria> cq = cb.createQuery(ProductoCafeteria.class);
            Root<ProductoCafeteria> root = cq.from(ProductoCafeteria.class);

            cq.select(root);

            List<ProductoCafeteria> eliana = em.createQuery(cq).getResultList();
            em.close();
            // Ejecutar la consulta
            return eliana;
        } catch (Exception e) {
            throw new PersitenciaException("Error al obtener todos los productos de cafetería: " + e.getMessage());
        }
    }

    @Override
    public ProductoCafeteria consultarProductosPorCodigo(String codigo) throws PersitenciaException {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ProductoCafeteria> cq = cb.createQuery(ProductoCafeteria.class);
            Root<ProductoCafeteria> root = cq.from(ProductoCafeteria.class);

            // Agregar predicado para filtrar por código
            cq.where(cb.equal(cb.lower(root.get("codigo")), codigo.toLowerCase()));

            // Ejecutar la consulta
            List<ProductoCafeteria> resultados = em.createQuery(cq).getResultList();
            em.close();
            // Devolver el primer resultado si existe
            if (!resultados.isEmpty()) {
                return resultados.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new PersitenciaException("Error al consultar productos por código: " + e.getMessage());
        }

    }

    @Override
    public List<ProductoCafeteria> consultarProductos(String palabra) throws PersitenciaException {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            String jpql = "SELECT p FROM ProductoCafeteria p WHERE p.nombre LIKE :palabra";

            TypedQuery<ProductoCafeteria> query = em.createQuery(jpql, ProductoCafeteria.class);
            query.setParameter("palabra", "%" + palabra + "%");
            List<ProductoCafeteria> productos = query.getResultList();

            em.getTransaction().commit();

            return productos;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersitenciaException("Error al obtener los productos de cafetería que coinciden con la palabra: " + palabra, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosAZ() throws PersitenciaException {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            List<ProductoCafeteria> productos = obtenerTodosLosProductos();

            // Sort the list
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre));

            em.getTransaction().commit();
            return productos;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersitenciaException("Error al ordenar productos de forma ascendente", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosZA() throws PersitenciaException {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            List<ProductoCafeteria> productos = obtenerTodosLosProductos();
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre).reversed());

            em.getTransaction().commit(); 
            return productos;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersitenciaException("Error al ordenar productos de forma descendente", e);
        } finally {
            em.close(); 
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosPorPrecio() throws PersitenciaException {
            em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            List<ProductoCafeteria> productos = obtenerTodosLosProductos();
            productos.sort(Comparator.comparingDouble(ProductoCafeteria::getPrecio));

            em.getTransaction().commit(); 
            return productos;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersitenciaException("Error al ordenar productos por precio", e);
        } finally {
            em.close(); 
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosAZ(List<ProductoCafeteria> productos) throws PersitenciaException {
        try {
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre));
            return productos;
        } catch (Exception e) {
            throw new PersitenciaException("Error al ordenar productos filtrados de forma ascendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosZA(List<ProductoCafeteria> productos) throws PersitenciaException {
        try {
            productos.sort(Comparator.comparing(ProductoCafeteria::getNombre).reversed());
            return productos;
        } catch (Exception e) {
            throw new PersitenciaException("Error al ordenar productos filtrados de forma descendente", e);
        }
    }

    @Override
    public List<ProductoCafeteria> ordenarProductosFiltradosPorPrecio(List<ProductoCafeteria> productos) throws PersitenciaException {
        try {
            productos.sort(Comparator.comparingDouble(ProductoCafeteria::getPrecio));
            return productos;
        } catch (Exception e) {
            throw new PersitenciaException("Error al ordenar productos filtrados por precio", e);
        }
    }
}
