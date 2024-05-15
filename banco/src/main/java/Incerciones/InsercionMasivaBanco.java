/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Incerciones;

import dominio.Tarjeta;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jl4ma
 */
public class InsercionMasivaBanco {

    public void insertarRegistros() {
        List<Tarjeta> tarjetas = new ArrayList<>();
        
        tarjetas.add(new Tarjeta("4696-1641-7464-6464", YearMonth.of(2030, 9), 754, 1000.0f));
        tarjetas.add(new Tarjeta("4696-6542-7464-6464", YearMonth.of(2035, 2), 475, 1000.0f));
        tarjetas.add(new Tarjeta("4696-1641-6546-6464", YearMonth.of(2032, 1), 277, 1000.0f));
        tarjetas.add(new Tarjeta("4696-1641-7464-6541", YearMonth.of(2027, 11), 341, 1000.0f));
        tarjetas.add(new Tarjeta("1545-1641-7464-6464", YearMonth.of(2025, 9), 734, 1000.0f));

        EntityManagerFactory emfBanco = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager emBanco = emfBanco.createEntityManager();

        emBanco.getTransaction().begin();
        for (Tarjeta tarjeta : tarjetas) {
            emBanco.persist(tarjeta);
        }
        emBanco.getTransaction().commit();
        emBanco.close();

    }
     public boolean datosExisten() {
        EntityManagerFactory emfBanco = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager emBanco = emfBanco.createEntityManager();

        TypedQuery<Long> query = emBanco.createQuery("SELECT COUNT(t) FROM Tarjeta t", Long.class);
        Long count = query.getSingleResult();

        emBanco.close();

        return count > 0;
    }
}
