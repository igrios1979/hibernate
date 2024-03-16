package org.igrios.hibernate.appp;

import jakarta.persistence.EntityManager;
import org.igrios.hibernate.appp.entity.Cliente;
import org.igrios.hibernate.appp.utility.JpaUtil;

import javax.swing.*;

public class InsercionConBoton {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {
            boolean continuar = true;
            while (continuar) {
                String nombre = JOptionPane.showInputDialog("Ingrese Nombre:");
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
                String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

                em.getTransaction().begin();

                Cliente cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTipoPago(pago);
                em.persist(cliente);
                System.out.println("ID insertado -->> " + cliente.getId());
                em.getTransaction().commit();

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    int confirmacionSalir = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Confirmación de salida", JOptionPane.YES_NO_OPTION);
                    if (confirmacionSalir == JOptionPane.YES_OPTION) {
                        continuar = false;
                    }
                }
            }
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
