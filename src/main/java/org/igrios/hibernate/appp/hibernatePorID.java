package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import java.util.Scanner;

public class hibernatePorID {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Long id = s.nextLong();


        System.out.println(" ingrese id:: " );
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class,id);
        System.out.println("cliente = " + cliente);
        em.close();


    }
}
