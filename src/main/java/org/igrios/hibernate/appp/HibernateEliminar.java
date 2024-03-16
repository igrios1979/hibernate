package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import javax.swing.text.html.parser.Entity;
import java.util.Scanner;

public class HibernateEliminar {


    public static void main(String[] args) {

        Scanner l = new Scanner(System.in);
        System.out.println("Ingrese valor a eliminar" );
        Long id = l.nextLong();
        EntityManager em = JpaUtil.getEntityManager();

        try{

            Cliente cliente = em.find(Cliente.class,id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();


        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();

        }



    }


}
