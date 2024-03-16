package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import javax.swing.*;

public class HibernateCrear {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            String nombre = JOptionPane.showInputDialog("Ingrese Nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTipoPago(pago);
            em.persist(cliente);

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
