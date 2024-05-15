/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import dominio.Tarjeta;
import excepciones.PersitenciaException;
import interfaces.ITarejaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author jl4ma
 */
public class TarjetaDAO implements ITarejaDAO{
    private EntityManager em;
    private EntityManagerFactory emf;

    public TarjetaDAO() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
        em = emf.createEntityManager();
    }

    
    @Override
    public Tarjeta consultarTarjeta(String num){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tarjeta> cq = cb.createQuery(Tarjeta.class);
        Root<Tarjeta> root = cq.from(Tarjeta.class);

        Predicate predicado = cb.equal(root.get("numeroTarjeta"), num);
        cq.select(root).where(predicado);
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            System.out.println("bo");
            return null;
        }
    }
}
