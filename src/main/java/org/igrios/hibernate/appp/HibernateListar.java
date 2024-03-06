package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;

import java.util.List;

public class HibernateListar {

    public static void main(String[] args) {
        EntityManager em = org.example.util.JpaUtil.getEntityManager();

      List<Cliente> clientes =   em.createQuery("select c from Cliente  c").getResultList();
      clientes.forEach(c-> System.out.println("c = " + c));
      em.close();

    }
}
