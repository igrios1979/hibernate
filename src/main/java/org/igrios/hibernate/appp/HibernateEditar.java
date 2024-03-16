package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import javax.swing.*;

public class HibernateEditar {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("ingrese el id del cliente:: "));
            Cliente c = em.find(Cliente.class,id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:" ,c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:" ,c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese el pago:" ,c.getTipoPago());

            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setTipoPago(pago);
            c.setApellido(apellido);
            em.merge(c);
            em.getTransaction().commit();


        }catch(Exception e){
          em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();

        }



    }
}
