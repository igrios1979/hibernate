package org.igrios.hibernate.appp;
/*-----------------*/
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import java.util.Scanner;

public class SingleResult {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
         Query query = em.createQuery("SELECT c from Cliente c where c.tipoPago=?1", Cliente.class);

            System.out.println("Ingrese una forma de pago: ");
            String pago = s.next();
            Query query1 = query.setParameter(1, pago);
            query.setMaxResults(1);

            Cliente c = (Cliente) query.getSingleResult();
            System.out.println("-->  " + c);

            em.close();


    }




}// Fin SingleResult
